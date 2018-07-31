package edu.kit.informatik;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

    private static String[][] currentBoard = new String[8][8];

    public static void throwinBoard(String currentPlayerName, int columnNumber) {
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

    public static String getState(int columnX, int columnY) {
        if (currentBoard[columnX][columnY] == null) {
            return "**";
        } else {
            return currentBoard[columnX][columnY];
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 8; i++) {
            String line = "";
            for (int j = 0; j < 8; j++) {
                line += getState(j, i) + " ";
            } System.out.println(line + "\t");
        }
    }

    public static void removeLastElem(int columnX) {
        currentBoard[columnX][7] = null;
        for (int i = 7; i >= 1; i--) {
            currentBoard[columnX][i] = currentBoard[columnX][i - 1];

        }
    }

//    public static void flip() {
//        int counter;
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (currentBoard[i][j] != null) {
//                    counter = j;
//                    for (int k = counter; k < 8; k++) {
//
//                    }
//                }
//
//            }
//        }
//    }

    public static void flip() {
        // Get rows from board
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
                    throwinBoard(unflippedBoard[i][j],i);
                }
            }
        }
    }


    public static String[][] getCurrentBoard() {
        return currentBoard;
    }
}
