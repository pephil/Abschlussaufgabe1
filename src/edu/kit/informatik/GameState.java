package edu.kit.informatik;

public class GameState {

    private static boolean isRunning;
    private static boolean isWon;
    private static boolean isDraw;

    public static void setWin() {
        isWon = true;
        isRunning = false;
    }

    public static boolean getWinStatus() {
        return isWon;
    }

    public static void setIsRunning(boolean status) {
        isRunning = status;
    }

    public static boolean getIsRunning() {
        return isRunning;
    }

}
