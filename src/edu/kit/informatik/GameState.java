package edu.kit.informatik;

public class GameState {

    private static boolean isRunning;
    private static boolean isWon;
    private static boolean isDraw;

    public static void setWin() {
        isWon = true;
    }

    public static boolean getWinStatus() {
        return isWon;
    }


}
