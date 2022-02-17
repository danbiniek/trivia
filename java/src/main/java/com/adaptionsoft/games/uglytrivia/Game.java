package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int currentPlayerNo = 0;
    private List<Player> players = new ArrayList<>();
    private boolean isGettingOutOfPenaltyBox;

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public void add(String playerName) {
        players.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        Player currentPlayer = getCurrentPlayer();
        System.out.println(currentPlayer.getName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.isPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
                currentPlayer.move(roll);
                logCurrentPlayerLocation(currentPlayer);
                System.out.println("The category is " + currentCategory());
                askQuestion();
            } else {
                System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            currentPlayer.move(roll);
            logCurrentPlayerLocation(currentPlayer);
            System.out.println("The category is " + currentCategory());
            askQuestion();
        }
    }

    private void logCurrentPlayerLocation(Player currentPlayer) {
        System.out.println(currentPlayer.getName()
                + "'s new location is "
                + currentPlayer.getPlace());
    }

    private void askQuestion() {
        currentCategory().ask();
    }

    private Category currentCategory() {
        if (getCurrentPlayerPlace() == 0) return Category.POP;
        if (getCurrentPlayerPlace() == 4) return Category.POP;
        if (getCurrentPlayerPlace() == 8) return Category.POP;
        if (getCurrentPlayerPlace() == 1) return Category.SCIENCE;
        if (getCurrentPlayerPlace() == 5) return Category.SCIENCE;
        if (getCurrentPlayerPlace() == 9) return Category.SCIENCE;
        if (getCurrentPlayerPlace() == 2) return Category.SPORT;
        if (getCurrentPlayerPlace() == 6) return Category.SPORT;
        if (getCurrentPlayerPlace() == 10) return Category.SPORT;
        return Category.ROCK;
    }

    private Player getCurrentPlayer() {
        return players.get(this.currentPlayerNo);
    }

    private int getCurrentPlayerPlace() {
        return getCurrentPlayer().getPlace();
    }

    public boolean wasCorrectlyAnswered() {
        Player currentPlayer = getCurrentPlayer();
        if (currentPlayer.isPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct!!!!");
                currentPlayer.incrementPurses();
                currentPlayer.moveOutFromPenaltyBox();
                logCurrentUserPurses(currentPlayer);

                boolean winner = didPlayerWin();
                this.currentPlayerNo++;
                if (this.currentPlayerNo == players.size()) this.currentPlayerNo = 0;

                return winner;
            } else {
                this.currentPlayerNo++;
                if (this.currentPlayerNo == players.size()) this.currentPlayerNo = 0;
                return true;
            }
        } else {
            System.out.println("Answer was correct!!!!");
            currentPlayer.incrementPurses();
            logCurrentUserPurses(currentPlayer);

            boolean winner = didPlayerWin();
            this.currentPlayerNo++;
            if (this.currentPlayerNo == players.size()) this.currentPlayerNo = 0;

            return winner;
        }
    }

    private void logCurrentUserPurses(Player currentPlayer) {
        System.out.println(currentPlayer.getName()
                + " now has "
                + currentPlayer.getPurses()
                + " Gold Coins.");
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(getCurrentPlayer().getName() + " was sent to the penalty box");
        getCurrentPlayer().movetoPenaltyBox();
        currentPlayerNo++;
        if (currentPlayerNo == players.size()) currentPlayerNo = 0;
        return true;
    }

    private boolean didPlayerWin() {
        return !(getCurrentPlayer().getPurses() == 6);
    }
}
