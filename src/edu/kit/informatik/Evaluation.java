package edu.kit.informatik;

/**
 * @author Philipp Peiser.
 * @version 02.08.2018., 1.1
 */
public class Evaluation {

    private static boolean p1Win = false;
    private static boolean p2Win = false;
    private static MessageHandler message = new MessageHandler();

    /**
     *
     * @param currentBoard
     */
    public Evaluation(String[][] currentBoard) {
        evaluateBoard(currentBoard);
    }

    /**
     * Evaluate method of the whole Board.
     *
     * @param currentBoard Two dimensional String array as the current board.
     */
    public void evaluateBoard(String[][] currentBoard) {

        evaluateHorizontal(currentBoard);
        evaluateVertical(currentBoard);
        evaluateDiagonalBottomRight(currentBoard);
        evaluateDiagonalBottomLeft(currentBoard);

        if (p1Win && p2Win) {
            message.printDraw();
            GameState.setWin();
        } else if (p2Win) {
            message.printWinner("P2");
            GameState.setWin();
        } else if (p1Win) {
            message.printWinner("P1");
            GameState.setWin();
        } else {
            message.printOK();
        }

    }

    /**
     * Method to evaluate the horizontal/Line of the Board and checks for a winner.
     *
     * @param currentBoard Two dimensional String array as the current board.
     */
    private void evaluateHorizontal(String[][] currentBoard) {

        for (int i = 0; i < 8; i++) {
            int p1 = 0;
            int p2 = 0;
            for (int j = 0; j < 8; j++) {
                if (currentBoard[i][j] != null && currentBoard[i][j].equals("P1")) {
                    p1++;
                    p2 = 0;
                } else if (currentBoard[i][j] != null && currentBoard[i][j].equals("P2")) {
                    p2++;
                    p1 = 0;
                }
                if (p1 == 4) {
                    p1Win = true;
                } else if (p2 == 4) {
                    p2Win = true;
                }
            }
        }
    }

    /**
     * Method to evaluate the vertical/column of the Board and checks for a winner.
     *
     * @param currentBoard Two dimensional String array as the current board.
     */
    private void evaluateVertical(String[][] currentBoard) {

        for (int i = 0; i < 8; i++) {
            int p1 = 0;
            int p2 = 0;

            for (int j = 0; j < 8; j++) {
                if (currentBoard[j][i] != null && currentBoard[j][i].equals("P1")) {
                    p1++;
                    p2 = 0;
                } else if (currentBoard[j][i] != null && currentBoard[j][i].equals("P2")) {
                    p2++;
                    p1 = 0;
                }
                if (p1 == 4) {
                    p1Win = true;
                } else if (p2 == 4) {
                    p2Win = true;
                }
            }
        }
    }

    /**
     * Evaluates the board and checks the diagonal line of the board from bottom left to upper right for a winner.
     *
     * @param currentBoard Two dimensional String array as the current board.
     */
    private void evaluateDiagonalBottomLeft(String[][] currentBoard) {

        int p1 = 0;
        int p2 = 0;

        for (int i = 7; i > 2; i--) {
            for (int j = 0; j < 5; j++) {
                if (currentBoard[j][i] != null && currentBoard[j][i].equals("P1")) {
                    p1++;
                    p2 = 0;
                    for (int k = 1; k < 4; k++) {
                        if (currentBoard[j + k][i - k] != null && currentBoard[j + k][i - k].equals("P1")) {
                            p1++;
                            p2 = 0;
                        } else {
                            p1 = 0;
                        }
                    }
                    if (p1 == 4) {
                        p1Win = true;
                    }
                } else if (currentBoard[j][i] != null && currentBoard[j][i].equals("P2")) {
                    p2++;
                    p1 = 0;
                    for (int k = 1; k < 4; k++) {
                        if (currentBoard[j + k][i - k] != null && currentBoard[j + k][i - k].equals("P2")) {
                            p2++;
                            p1 = 0;
                        } else {
                            p2 = 0;
                        }
                    }
                    if (p2 == 4) {
                        p2Win = true;
                    }
                }
            }
        }
    }

    /**
     * Evaluates the board and checks the diagonal line of the board from bottom right to upper left for a winner.
     *
     * @param currentBoard Two dimensional String array as the current board.
     */
    private void evaluateDiagonalBottomRight(String[][] currentBoard) {

        int p1 = 0;
        int p2 = 0;

        for (int i = 7; i > 2; i--) {
            for (int j = 7; j > 2; j--) {
                if (currentBoard[j][i] != null && currentBoard[j][i].equals("P1")) {
                    p1++;
                    p2 = 0;
                    for (int k = 1; k < 4; k++) {
                        if (currentBoard[j - k][i - k] != null && currentBoard[j - k][i - k].equals("P1")) {
                            p1++;
                            p2 = 0;
                        } else {
                            p1 = 0;
                        }
                    }
                    if (p1 == 4) {
                        p1Win = true;
                    }
                } else if (currentBoard[j][i] != null && currentBoard[j][i].equals("P2")) {
                    p2++;
                    p1 = 0;
                    for (int k = 1; k < 4; k++) {
                        if (currentBoard[j - k][i - k] != null && currentBoard[j - k][i - k].equals("P2")) {
                            p2++;
                            p1 = 0;
                        } else {
                            p2 = 0;
                        }
                    }
                    if (p2 == 4) {
                        p2Win = true;
                    }
                }
            }
        }
    }
}
