package edu.kit.informatik;

/**
 *@author Philipp Peiser.
 * @version 02.08.2018., 1.1
 */
public class Board {

    private static String[][] currentBoard;
    private static MessageHandler message = new MessageHandler();

    /**
     *
     */
    public Board(){currentBoard = new String [8][8]; }



    /**
     * Throwin method that throws a token of the current player into the given column number of the board.
     *
     * @param currentPlayerName String of the current Players name.
     * @param columnNumber Integer of the column Number where the token is going to be thrown in.
     */
    public void throwinBoard(String currentPlayerName, int columnNumber) {
        for (int i = 0; i < 8; i++) {
            if (currentBoard[columnNumber][i] != null && i != 0) {
                currentBoard[columnNumber][i - 1] = currentPlayerName;
                return;
            } else if (currentBoard[columnNumber][7] == null) {
                currentBoard[columnNumber][7] = currentPlayerName;
                return;
            }
        }
    }

    /**
     * State Method of the Board which returns the state of a given place on the board.
     *
     * @param columnX Is the given column of the asked state on the board.
     * @param lineY Is the given line of the asked state on the board.
     * @return String of which Players token is in the place on the board or if it's empty.
     */
    public String getState(int columnX, int lineY) {
        if (currentBoard[columnX][lineY] == null) {
            return "**";
        } else {
            return currentBoard[columnX][lineY];
        }
    }

    /**
     * Print method of the whole board using the state method.
     */
    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            String line = "";
            for (int j = 0; j < 8; j++) {
                line += getState(j, i) + " ";
            } message.printLine(line);
        }
    }

    /**
     * Remove method of the Board to remove the last Token of a given column if it's the token of the current player.
     *
     * @param columnX Given column Number where to remove the last Token.
     */
    public void removeLastElem(int columnX) {
        currentBoard[columnX][7] = null;
        for (int i = 7; i >= 1; i--) {
            currentBoard[columnX][i] = currentBoard[columnX][i - 1];
        }
    }

    /**
     * Flip method of the Board to flip all Places of tokens upside down.
     */
    public void flip() {
        String[][] unflippedBoard = currentBoard;
        currentBoard = new String[][]{
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},

        };
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (unflippedBoard[i][j] != null) {
                    throwinBoard(unflippedBoard[i][j], i);
                }
            }
        }
    }

    public void evaluateBoard() {
        Evaluation currentBoardEvaluation = new Evaluation(currentBoard);
    }


    /**
     * Getter method of the current Board.
     *
     * @return Two dimensional String array as the current Board.
     */
    public static String[][] getCurrentBoard() {
        return currentBoard;
    }
}
