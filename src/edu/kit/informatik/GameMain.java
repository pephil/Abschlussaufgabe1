package edu.kit.informatik;

/**
 * @author Philipp Peiser.
 * @version 02.08.2018., 1.1
 *
 */
public class GameMain {
    private static int amountOfTokens;
    private static Board board = new Board();
    private static MessageHandler message = new MessageHandler();

    /**
     * Main method of the program.
     *
     * @param args Array of strings of the given command line arguments.
     */
    public static void main(String[] args) {
        Command command = null;

        try {
            if (Command.checkInput(args)) {
                amountOfTokens = Integer.parseInt(args[1]);
                do {
                    try {
                        command = Command.executeMatching(Terminal.readLine(), amountOfTokens, board);
                    } catch (InputException e) {
                        message.printError(e.getMessage());
                    }
                } while (command == null || command.isRunning());
            }
        } catch (InputException e) {
            message.printError(e.getMessage());
        }
    }

    /**
     * Getter method for the player tokens.
     *
     * @return the amount of tokens both players have in the current state of game.
     */
    public static int getAmountOfTokens() {
        return amountOfTokens;
    }

    /**
     * Method that counts down the amount of tokens after both players threw a token into the board.
     */
    public static void tokenThrowin() {
        amountOfTokens--;

    }
}
