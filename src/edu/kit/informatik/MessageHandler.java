package edu.kit.informatik;

public class MessageHandler {


    public static void printOK() {
        Terminal.printLine("OK");
    }

    public static void printState(int columnNumberX, int columnNumberY) {
        Terminal.printLine(Board.getState(columnNumberX, columnNumberY));
    }

    public static void printToken() {
        Terminal.printLine(GameMain.getAmountOfTokens());
    }

    public static void printError(String message) {
        Terminal.printError(message);
    }

    public static void printRemoveError() {
        Terminal.printError("remove not possible (not your token)");
    }

}
