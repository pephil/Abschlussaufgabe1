package edu.kit.informatik;

public class Evaluation {

    private static boolean p1Win = false;
    private static boolean p2Win = false;

    public static boolean evaluateBoard(String[][] currentBoard) {


        evaluateHorizontal(currentBoard);
        evaluateVertical(currentBoard);
        evaluateDiagonalBottomRight(currentBoard);
        evaluateDiagonalBottomLeft(currentBoard);

        if (p1Win && p2Win) {
            MessageHandler.printDraw();
            GameState.setWin();
            return true;
        } else if (p2Win) {
            MessageHandler.printWinner("P2");
            GameState.setWin();
            return true;
        } else if (p1Win) {
            MessageHandler.printWinner("P1");
            GameState.setWin();
            return true;
        } else {
            MessageHandler.printOK();
            return false;
        }

    }

    private static void evaluateHorizontal(String[][] currentBoard) {

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

    private static void evaluateVertical(String[][] currentBoard) {

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

    private static void evaluateDiagonalBottomLeft(String[][] currentBoard) {

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

    public static void evaluateDiagonalBottomRight(String[][] currentBoard) {

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

    public static void main(String[] args) {
        String[][] currentBoard = new String[][]{
                {null, null, null, null, "P1", null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, "P1", null},
                {null, null, null, null, null, null, null, "P1"},
                {null, null, null, null, "P2", null, "P1", null},
                {null, null, null, null, "P1", "P2", "P1", "P2"},
                {null, null, null, "P1", "P1", "P1", "P2", "P2"},
                {null, null, "P2", "P2", "P2", "P1", "P1", "P2"},

        };
        System.out.println(Evaluation.evaluateBoard(currentBoard));
    }

}
