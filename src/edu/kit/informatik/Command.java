package edu.kit.informatik;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public enum Command {


    /**
     * Throwin command to throwin a token into the board.
     */
    THROWIN("throwin ([0,1,2,3,4,5,6,7])") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            if (GameState.getIsRunning()) {
                int columnNumber = Integer.parseInt(matcher.group(1));
                Board.throwinBoard(getCurrentPlayer().getPlayerName(), columnNumber);
                playsCounter++;
                GameMain.tokenThrowin();
                Player.changePlayer();
                Evaluation.evaluateBoard(Board.getCurrentBoard());
            } else {
                MessageHandler.printGameOver();
            }
        }
    },

    /**
     * Flip command to flip the board when the program is started in flip mode.
     */
    FLIP("flip") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            if (FlipMode.getStatus()) {
                if (GameState.getIsRunning()) {
                    Board.flip();
                    Player.changePlayer();
                    Evaluation.evaluateBoard(Board.getCurrentBoard());
                } else {
                    MessageHandler.printGameOver();
                }
            } else {
                MessageHandler.printWrongModeFlip();
            }
        }
    },

    /**
     * Remove command to remove the token of the current player if the game is in remove mode.
     */
    REMOVE("remove ([0,1,2,3,4,5,6,7])") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            if (RemoveMode.getStatus()) {
                if (GameState.getIsRunning()) {
                    int columnNumber = Integer.parseInt(matcher.group(1));
                    if (Board.getState(columnNumber, 7).equals(Player.getPlayerName())) {
                        Board.removeLastElem(columnNumber);
                        Player.changePlayer();
                        Evaluation.evaluateBoard(Board.getCurrentBoard());
                    } else {
                        MessageHandler.printRemoveError();
                    }
                } else {
                    MessageHandler.printGameOver();
                }
            } else {
                MessageHandler.printWrongModeRemove();
            }
        }
    },

    /**
     * Token command, shows how many tokens the current player has left.
     */
    TOKEN("token") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            MessageHandler.printToken();
        }
    },

    /**
     * State commmand shows in which state the given position is (player 1 or 2 or empty).
     */
    STATE("state ([0,1,2,3,4,5,6,7]);([0,1,2,3,4,5,6,7])") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            int columnNumberX = Integer.parseInt(matcher.group(1));
            int columnNumberY = Integer.parseInt(matcher.group(2));
            MessageHandler.printState(columnNumberX, columnNumberY);
        }
    },

    /**
     * Print command prints the board.
     */
    PRINT("print") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            Board.printBoard();
        }
    },
    /**
     * Quit command quits the current game session.
     */
    QUIT("quit") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            isRunning = false;
        }
    };

    private static final int NUMBER_OF_ARGUMENTS = 2;
    private static int playsCounter;
    private static boolean isRunning = true;
    private static Player currentPlayer;
    private Pattern pattern;

    /**
     * Constructor for a new command.
     * @param pattern Regex pattern to validate and execute the command.
     */
    Command(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    /**
     *
     * @param args is the String array given with the start of the program
     * @return if returned true, the arguments are valid
     * @throws InputException If the user didn't started the game with an argument in a valid form.
     */
    public static boolean checkInput(String[] args) throws InputException {

        if (args.length == NUMBER_OF_ARGUMENTS) {
            if (args[0].matches("standard") && args[1].matches("^(28|29|30|31|32)")
                    || args[0].matches("flip") && args[1].matches("^(28|29|30|31|32)")
                    || args[0].matches("remove") && args[1].matches("^(28|29|30|31|32)")) {
                switch (args[0]) {
                    case "standard":
                        GameState.setIsRunning(true);
                        break;
                    case "remove":
                        RemoveMode.setStatus(true);
                        GameState.setIsRunning(true);
                        break;
                    case "flip":
                        FlipMode.setStatus(true);
                        GameState.setIsRunning(true);
                        break;
                    default:
                        break;
                }
                return true;
            } else {
                throw new InputException("wrong type of Input (must be: standard/flip/remove + 28-32)");
            }
        }
        throw new InputException("only two arguments allowed (Gamemode and amount of Playertokens)");
    }

    /**
     * Matches input with existing commands and executes it when applicable.
     *
     * @param input This string is the users command written into the console.
     * @param numberOfTokens The amount of tokens which the user started the game with.
     * @return Returns the command the user entered.
     * @throws InputException If the user didn't enter a command in a valid form.
     */
    public static Command executeMatching(String input, int numberOfTokens) throws InputException {
        for (Command command : Command.values()) {
            Matcher matcher = command.pattern.matcher(input);
            if (matcher.matches()) {
                command.execute(matcher, numberOfTokens);
                return command;
            }
        }
        throw new InputException("not a valid command");
    }

    /**
     *
     * Executes a command.
     *
     * @param matcher The Regex matcher.
     * @param numberOfTokens Tokens both players have in the current state of the game.
     */
    public abstract void execute(MatchResult matcher, int numberOfTokens);

    /**
     * Checks if the program is still running.
     *
     * @return boolean if the program is running.
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Getter method for the current Player.
     *
     * @return The current Player of the game.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Getter of the number of Plays in the game.
     *
     * @return The number of Plays in the current game.
     */
    public static int getPlaysCounter() {
        return playsCounter;
    }
}
