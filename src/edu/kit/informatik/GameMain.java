package edu.kit.informatik;

public class GameMain {
    private static int amountOfTokens;

    public static void main(String[] args) {
        Command command = null;

        try {
            if (Command.checkInput(args)) {
                amountOfTokens = Integer.parseInt(args[1]);
                do {
                    try {
                        command = Command.executeMatching(Terminal.readLine(), amountOfTokens);
                    } catch (InputException e) {
                        MessageHandler.printError(e.getMessage());
                    }
                } while (command == null || command.isRunning());
            }
        } catch (InputException e) {
            MessageHandler.printError(e.getMessage());
        }
    }

    public static int getAmountOfTokens() {
        return amountOfTokens;
    }

    public static void tokenThrowin() {
        if (Command.getPlaysCounter() != 1 && Player.getPlayerName().equals("P1")) {
            amountOfTokens--;
        }

    }
}
