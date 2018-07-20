package edu.kit.informatik;

public class RegularMode {

    private static boolean isCurrentMode = false;
    private int numberOfTokens;

    public RegularMode(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }

    public static void setStatus(boolean status) {
        isCurrentMode = status;
    }

    public boolean getCurrentMode() {
        return isCurrentMode;
    }
}
