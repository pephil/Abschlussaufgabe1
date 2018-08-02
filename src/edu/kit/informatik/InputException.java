package edu.kit.informatik;

/**
 * @author Philipp Peiser.
 * @version 02.08.2018., 1.1
 */
class InputException extends Exception {
    /**
     * Constructs InputException.
     *
     * @param errorMessage The error message to display to the user.
     */
    InputException(String errorMessage) {
        super(errorMessage);
    }
}
