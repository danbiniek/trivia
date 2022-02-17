package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int currentPlayer = 0;
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
        System.out.println(currentPlayer + " is the current currentPlayer");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.isPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(currentPlayer + " is getting out of the penalty box");
                currentPlayer.move(roll);
                logCurrentLocation(currentPlayer);
                System.out.println("The category is " + currentCategory());
                askQuestion();
            } else {
                System.out.println(currentPlayer + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {
            currentPlayer.move(roll);
            logCurrentLocation(currentPlayer);
            System.out.println("The category is " + currentCategory());
            askQuestion();
        }

    }

    private void logCurrentLocation(Player currentPlayer) {
        System.out.println(currentPlayer
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
        return players.get(this.currentPlayer);
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
                this.currentPlayer++;
                if (this.currentPlayer == players.size()) this.currentPlayer = 0;

                return winner;
            } else {
                this.currentPlayer++;
                if (this.currentPlayer == players.size()) this.currentPlayer = 0;
                return true;
            }
        } else {
            System.out.println("Answer was corrent!!!!");
            currentPlayer.incrementPurses();
            logCurrentUserPurses(currentPlayer);

            boolean winner = didPlayerWin();
            this.currentPlayer++;
            if (this.currentPlayer == players.size()) this.currentPlayer = 0;

            return winner;
        }
    }

    private void logCurrentUserPurses(Player currentPlayer) {
        System.out.println(players.get(this.currentPlayer)
                + " now has "
                + currentPlayer.getPurses()
                + " Gold Coins.");
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
        getCurrentPlayer().movetoPenaltyBox();
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }


    private boolean didPlayerWin() {
        return !(getCurrentPlayer().getPurses() == 6);
    }
}
