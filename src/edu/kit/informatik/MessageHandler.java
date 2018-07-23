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

    public static void printWinner(String player) {
        Terminal.printLine(player + " wins");
    }

    public static void printGameOver() {
        Terminal.printError("game is already over!");
    }

    public static void printWrongModeFlip() {
        Terminal.printError("flip command not allowed in current mode");
    }

    public static void printWrongModeRemove() {
        Terminal.printError("remove command not allowed in current mode");
    }
}
