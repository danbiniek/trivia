package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int currentPlayerNo = 0;
    private List<Player> players = new ArrayList<>();
    private boolean isGettingOutOfPenaltyBox;
    private final GameBoard gameBoard;

    public Game() {
        this.gameBoard = new GameBoard();
    }

    public void add(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
        gameBoard.addPlayer(player);
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + gameBoard.getNumberOfPlayers());
    }

    public int howManyPlayers() {
        return gameBoard.getNumberOfPlayers();
    }

    public void roll(int roll) {
        System.out.println(getCurrentPlayer().getName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (getCurrentPlayer().isPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                System.out.println(getCurrentPlayer().getName() + " is getting out of the penalty box");
                gameBoard.movePlayer(getCurrentPlayer(), roll);
                logCurrentPlayerLocation();
                askQuestion();
            } else {
                System.out.println(getCurrentPlayer().getName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            gameBoard.movePlayer(getCurrentPlayer(), roll);
            logCurrentPlayerLocation();
            askQuestion();
        }
    }

    public boolean wasCorrectlyAnswered() {
        if (getCurrentPlayer().isPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct!!!!");
                getCurrentPlayer().incrementPurses();
                getCurrentPlayer().moveOutFromPenaltyBox();
                logCurrentUserPurses(getCurrentPlayer());

                boolean winner = didPlayerWin();
                changePlayer();

                return winner;
            } else {
                changePlayer();
                return true;
            }
        } else {
            System.out.println("Answer was correct!!!!");
            getCurrentPlayer().incrementPurses();
            logCurrentUserPurses(getCurrentPlayer());

            boolean winner = didPlayerWin();
            changePlayer();

            return winner;
        }
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(getCurrentPlayer().getName() + " was sent to the penalty box");
        getCurrentPlayer().movetoPenaltyBox();
        currentPlayerNo++;
        if (currentPlayerNo == players.size()) currentPlayerNo = 0;
        return true;
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    private void logCurrentPlayerLocation() {
        System.out.println(getCurrentPlayer().getName()
                + "'s new location is "
                + getCurrentPlayerPlace());
    }

    private void askQuestion() {
        var category = gameBoard.getCategory(getCurrentPlayer());
        System.out.println("Current category: " + category.name());
        category.ask();
    }

    private int getCurrentPlayerPlace() {
        return gameBoard.getPlayers().get(getCurrentPlayer());
    }

    private void changePlayer() {
        this.currentPlayerNo++;
        if (this.currentPlayerNo == players.size()) {
            this.currentPlayerNo = 0;
        }
    }

    private void logCurrentUserPurses(Player currentPlayer) {
        System.out.println(currentPlayer.getName()
                + " now has "
                + currentPlayer.getPurses()
                + " Gold Coins.");
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayerNo);
    }

    private boolean didPlayerWin() {
        return getCurrentPlayer().getPurses() != 6;
    }
}
