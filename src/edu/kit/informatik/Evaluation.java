package edu.kit.informatik;

public class Evaluation {

    public static void evaluateBoard(String[][] currentBoard) {
        //vertical horizontal wieder einfügen
        if (!evaluateDiagonal1(currentBoard)) {
            MessageHandler.printOK();
        } else {
            GameState.setWin();
        }
        //evaluateDiagonal1(currentBoard);
    }

    private static boolean evaluateHorizontal(String[][] currentBoard) {

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
                    MessageHandler.printWinner("P1");
                    return true;
                } else if (p2 == 4) {
                    MessageHandler.printWinner("P2");
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean evaluateVertical(String[][] currentBoard) {

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
                    MessageHandler.printWinner("P1");
                    return true;
                } else if (p2 == 4) {
                    MessageHandler.printWinner("P2");
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean evaluateDiagonal1(String[][] currentBoard) {

        int p1 = 0;
        int p2 = 0;

        for (int i = 7; i > 2; i--) {
            for (int j = 0; j < 5; j++) {
                if (currentBoard[j][i] != null && currentBoard[j][i].equals("P1")) {
                    p1++;
                    p2 = 0;
                    for (int k = 0; k < 4; k++) {
                        if (currentBoard[j + k][i - k] != null && currentBoard[j + k][i - k].equals("P1")) {
                            p1++;
                            p2 = 0;
                        }
                    }
                    if (p1 == 4) {
                        MessageHandler.printWinner("P1");
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
