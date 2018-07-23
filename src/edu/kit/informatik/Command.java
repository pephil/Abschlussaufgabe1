package edu.kit.informatik;

import sun.plugin2.message.Message;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public enum Command {


    THROWIN("throwin ([0,1,2,3,4,5,6,7])") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            if (GameState.getIsRunning()) {
                int columnNumber = Integer.parseInt(matcher.group(1));
                Board.throwinBoard(getCurrentPlayer(), columnNumber);
                playsCounter++;
                GameMain.tokenThrowin();
                Player.changePlayer();
                Evaluation.evaluateBoard(Board.getCurrentBoard());
            } else {
                MessageHandler.printGameOver();
            }
        }
    },

    FLIP("flip") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            if (FlipMode.getStatus()) {
                if (GameState.getIsRunning()) {
                    Board.flip();
                    Player.changePlayer();
                    MessageHandler.printOK();
                } else {
                    MessageHandler.printGameOver();
                }
            } else {
                MessageHandler.printWrongModeFlip();
            }
        }
    },

    REMOVE("remove ([0,1,2,3,4,5,6,7])") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            if (RemoveMode.getStatus()) {
                if (GameState.getIsRunning()) {
                    int columnNumber = Integer.parseInt(matcher.group(1));
                    if (Board.getState(columnNumber, 7).equals(Player.getPlayerName())) {
                        Board.removeLastElem(columnNumber);
                        Player.changePlayer();
                        MessageHandler.printOK();
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

    TOKEN("token") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            MessageHandler.printToken();
        }
    },

    STATE("state ([0,1,2,3,4,5,6,7]);([0,1,2,3,4,5,6,7])") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            int columnNumberX = Integer.parseInt(matcher.group(1));
            int columnNumberY = Integer.parseInt(matcher.group(2));
            MessageHandler.printState(columnNumberX, columnNumberY);
        }
    },

    PRINT("print") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            Board.printBoard();
        }
    },

    QUIT("quit") {
        @Override
        public void execute(MatchResult matcher, int numberOfTokens) {
            isRunning = false;
        }
    };

    private static final int numberOfArguments = 2;
    private static int playsCounter;
    private static boolean isRunning = true;
    private static Player currentPlayer;
    private Pattern pattern;

    Command(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public static boolean checkInput(String[] args) throws InputException {

        if (args.length == numberOfArguments) {
            if (args[0].matches("standard") && args[1].matches("^(28|29|30|31|32)")
                    || args[0].matches("flip") && args[1].matches("^(28|29|30|31|32)")
                    || args[0].matches("remove") && args[1].matches("^(28|29|30|31|32)")) {
                switch (args[0]) {
                    case "standard":
                        RegularMode.setStatus(true);
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

    public static Command executeMatching(String input, int numberOfTokens) throws InputException {
        for (Command command : Command.values()) {
            Matcher matcher = command.pattern.matcher(input);
            if (matcher.matches()) {
                currentPlayer = new Player(numberOfTokens);
                command.execute(matcher, numberOfTokens);
                return command;
            }
        }
        throw new InputException("not a valid command");

    }

    public abstract void execute(MatchResult matcher, int numberOfTokens);

    public boolean isRunning() {
        return isRunning;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static int getPlaysCounter() {
        return playsCounter;
    }
}
