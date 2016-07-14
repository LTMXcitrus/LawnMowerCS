package test;

import program.Program;

public class Main {
    public static void main(String[] args) {
        String instructions =
                "5 5\n" +
                "1 2 N\n" +
                "GAGAGAGAA\n" +
                "3 3 E\n" +
                "AADAADADDA\n";
        Program program = new Program(instructions);
        System.out.println(program.execute());
    }
}