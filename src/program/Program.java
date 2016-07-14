package program;

import com.sun.javaws.exceptions.InvalidArgumentException;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Program {

    Grid grid;
    List<MowerInstruction> instructions;

    public Program(String instructions) {
        try {
            String[] splittedInstructions = instructions.split("\n"); //separate lines
            String gridInstructions = splittedInstructions[0];
            buildGrid(gridInstructions);
            buildMowersAndInstructions(splittedInstructions);
        } catch (InvalidArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public String execute() {
        String result = "";
        for (MowerInstruction instruction : instructions) {
            result += instruction.execute() + "\n";
        }
        return result;
    }


    private void buildGrid(String gridInstructions) throws InvalidArgumentException {
        String[] splittedInstructions = gridInstructions.split(" ");
        this.grid = new Grid(Integer.parseInt(splittedInstructions[0]), Integer.parseInt(splittedInstructions[1]));
    }

    private void buildMowersAndInstructions(String[] instructions) throws InvalidArgumentException {
        int size = (instructions.length - 1) / 2;
        this.instructions = new ArrayList<>(size);
        int i = 1;
        while (i < instructions.length) {
            this.instructions.add(new MowerInstruction(buildMower(instructions[i]), buildInstructions(instructions[i + 1])));
            i = i + 2;
        }
    }

    private List<Instruction> buildInstructions(String instructions) throws InvalidArgumentException {
        List<Instruction> moveInstructions = new ArrayList<>(instructions.length());
        char[] splittedInstructions = instructions.toCharArray();
        for (char splittedInstruction : splittedInstructions) {
            moveInstructions.add(Instruction.getInstruction(splittedInstruction));
        }
        return moveInstructions;
    }

    private LawnMower buildMower(String instructions) throws InvalidArgumentException {
        String[] splittedInstructions = instructions.split(" ");
        Position position = new Position(Integer.parseInt(splittedInstructions[0]), Integer.parseInt(splittedInstructions[1]));
        Orientation orientation = Orientation.getOrientation(splittedInstructions[2]);
        return new LawnMower(position, orientation, this.grid);
    }
}
