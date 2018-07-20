package edu.kit.informatik;

public class FlipMode {
    private static boolean isActive = false;
    private int numberOfTokens;

    public FlipMode(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }

    public static void setStatus(boolean status) {
        isActive = status;
    }

    public static boolean getStatus() {
        return isActive;
    }
}
