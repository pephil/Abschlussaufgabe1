package edu.kit.informatik;

public class RemoveMode {

    private static boolean isActive = false;
    private int numberOfTokens;

    public RemoveMode(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }

    public static boolean getStatus() {
        return isActive;
    }

    public static void setStatus(boolean status) {
        isActive = status;
    }
}
