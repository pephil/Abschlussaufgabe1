package edu.kit.informatik;

/**
 * @author Philipp Peiser.
 * @version 02.08.2018., 1.1
 *
 */
public class GameMain {
    private static int amountOfTokens;

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
                        command = Command.executeMatching(Terminal.readLine(), amountOfTokens);
                    } catch (InputException e) {
                        MessageHandler.printError(e.getMessage());
                    }
                } while (command == null || command.isRunning());
            }
        } catch (InputException e) {
            MessageHandler.printError(e.getMessage());
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
        if (Command.getPlaysCounter() != 1 && Player.getPlayerName().equals("P1")) {
            amountOfTokens--;
        }

    }
}
