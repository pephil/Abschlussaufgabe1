package edu.kit.informatik;

/**
 * @author Philipp Peiser.
 * @version 02.08.2018., 1.1
 */
public class Player {

    private static String player;

    public Player() { player = "P1"; }

    /**
     * Method to change the current player.
     */
    public void changePlayer() {
        if (player.equals("P1")) {
            player = "P2";
        } else if (player.equals("P2")) {
            player = "P1";
        }
    }

    /**
     * Getter method of the String name of the current player.
     *
     * @return String as the name of the current player.
     */
    public String getPlayerName() {
        return player;
    }

    /**
     *
     */
    public void tokenThrowin() {
        if (Command.getPlaysCounter() != 1 && player.equals("P1")) {
            GameMain.tokenThrowin();
        }
    }

}
