package edu.kit.informatik;

/**
 * @author Philipp Peiser.
 * @version 02.08.2018., 1.1
 */
public class RemoveMode {

    private static boolean isActive = false;

    /**
     * Setter method of the status of the remove mode.
     *
     * @param status Boolean if remove mode is active.
     */

    public static void setStatus(boolean status) {
        isActive = status;
    }

    /**
     * Getter method of the status of the remove mode.
     *
     * @return Boolean if active or not.
     */

    public static boolean getStatus() {
        return isActive;
    }
}
