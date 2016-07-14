package program;

import model.Instruction;
import model.LawnMower;

import java.util.List;

public class MowerInstruction {
    LawnMower mower;
    List<Instruction> instructions;

    public MowerInstruction(LawnMower mower, List<Instruction> instructions){
        this.instructions = instructions;
        this.mower = mower;
    }

    public String execute(){
        for(Instruction instruction : instructions){
            mower.move(instruction);
        }
        return mower.toString();
    }
}
