package edu.kit.informatik;

/**
 * @author Philipp Peiser.
 * @version 02.08.2018., 1.1
 */
public class FlipMode {

    private static boolean isActive = false;

    /**
     * Setter method of the status of the flip mode.
     *
     * @param status Boolean if flip mode is active.
     */
    public static void setStatus(boolean status) {
        isActive = status;
    }

    /**
     * Getter method of the status of the flip mode.
     *
     * @return Boolean if active or not.
     */
    public static boolean getStatus() {
        return isActive;
    }
}
