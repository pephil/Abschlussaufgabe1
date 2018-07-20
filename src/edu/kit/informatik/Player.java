package edu.kit.informatik;

public class Player {

    private static int amountOfTokens;
    private static String player = "P1";


    public Player(int amountOfTokens) {
        this.amountOfTokens = amountOfTokens;
    }

    public static void changePlayer() {
        if (player.equals("P1")) {
            player = "P2";
        } else if (player.equals("P2")) {
            player = "P1";
        }
    }

    public static int getAmountOfTokens() {
        return amountOfTokens;
    }

    public static void tokenThrowin() {

    }

    public static String getPlayerName() {
        return player;
    }

}
