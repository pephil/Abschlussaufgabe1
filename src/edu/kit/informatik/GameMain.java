package edu.kit.informatik;

public class GameMain {
    private static final int number_of_arguments = 2;

    public static void main(String[] args) {
        if(args.length < number_of_arguments) {
            Terminal.printError("not enough arguments given");

        } else if(args.length > number_of_arguments) {
            Terminal.printError("too many arguments given");
        }
        Board currentBoard = new Board();
    }
}
