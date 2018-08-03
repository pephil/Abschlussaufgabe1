package edu.kit.informatik;

/**
 * @author Philipp Peiser.
 * @version 02.08.2018., 1.1
 */
public class MessageHandler {

    /**
     *
     */
    public MessageHandler() { }

    /**
     * Prints "OK" for the current player after an valid command.
     */
    public void printOK() {
        Terminal.printLine("OK");
    }

    /**
     * Prints the state for the user.
     * @param columnNumberX Integer of the column number to get the current state from.
     * @param lineNumberY Integer of the line number to get the current state from.
     */
    public void printState(int columnNumberX, int lineNumberY, Board board) {
        Terminal.printLine(board.getState(columnNumberX, lineNumberY));
    }

    /**
     * Method that prints the amount of tokens left for the current player
     */
    public void printToken() {
        Terminal.printLine(GameMain.getAmountOfTokens());
    }

    /**
     * Method that prints an error after an invalid argument of command.
     * @param message String is the message that get's printed.
     */
    public void printError(String message) {
        Terminal.printError(message);
    }

    /**
     * Prints error if the current remove command is invalid because its not the token of the current player.
     */
    public void printRemoveError() {
        Terminal.printError("remove not possible (not your token)");
    }

    /**
     * Prints the winner of the game after the evaluate method chekced for a winner.
     * @param playerName String of the name of the player who won the game.
     */
    public void printWinner(String playerName) {
        Terminal.printLine(playerName + " wins");
    }

    /**
     * Method that prints an error after the game is over and an invalid command is given by the current player.
     */
    public void printGameOver() {
        Terminal.printError("game is already over!");
    }

    /**
     * Method that prints an Error if the flip command is not allowed in current mode.
     */
    public void printWrongModeFlip() {
        Terminal.printError("flip command not allowed in current mode");
    }

    /**
     * Method that prints an Error if the remove command is not allowed in current mode.
     */
    public void printWrongModeRemove() {
        Terminal.printError("remove command not allowed in current mode");
    }

    /**
     * Method that prints "draw" if both players won or out of tokens.
     */
    public void printDraw() {
        Terminal.printLine("draw");
    }

    /**
     * Method that prints a line for the board class "print".
     * @param line String given by the board class "print".
     */
    public void printLine(String line) {
        Terminal.printLine(line + "\t");
    }
}
