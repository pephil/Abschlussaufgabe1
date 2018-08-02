package edu.kit.informatik;

/**
 * @author Philipp Peiser.
 * @version 02.08.2018., 1.1
 */
public class GameState {

    private static boolean isRunning;

    /**
     * Setter method if the Game is won (by one player or both) and quit the game.
     */
    public static void setWin() {
        isRunning = false;
    }

    /**
     * Setter method if the arguments with the start of the program are correct it is set running.
     * @param status Boolean if arguments matched in Command class or not.
     */
    public static void setIsRunning(boolean status) {
        isRunning = status;
    }

    /**
     * Getter method for the state of the game if it's running or not.
     * @return Boolean if the current Game is running or over.
     */
    public static boolean getIsRunning() {
        return isRunning;
    }
}
