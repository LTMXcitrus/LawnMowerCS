package model;

import com.sun.javaws.exceptions.InvalidArgumentException;

public enum Instruction {
    D, G, A;

    public static Instruction getInstruction(char s) throws InvalidArgumentException {
        switch (s) {
            case 'D':
                return Instruction.D;
            case 'G':
                return Instruction.G;
            case 'A':
                return Instruction.A;
            default:
                throw new InvalidArgumentException(new String[]{"Instruction values can only be one among \"D\", \"G\", \"A\""});
        }
    }
}
