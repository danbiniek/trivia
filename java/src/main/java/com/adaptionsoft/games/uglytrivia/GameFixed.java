package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class GameFixed implements IGame {

    private final QuestionCategories questionCategories;
    private final List<Player> players = new ArrayList();
    private int currentPlayer = 0;

    public GameFixed() {
        questionCategories = new QuestionCategories();
    }

    public void add(String playerName) {
        players.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
    }

    public void roll(int roll) {
        System.out.println(getCurrentPlayer().getPlayerName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (getCurrentPlayer().isInPenaltyBox()) {
            if (roll % 2 != 0) {
                getCurrentPlayer().gettingOutOfPenaltyBox();

                System.out.println(getCurrentPlayer().getPlayerName() + " is getting out of the penalty box");
                getCurrentPlayer().move(roll);
                System.out.println(getCurrentPlayer().getPlayerName()
                        + "'s new location is "
                        + getCurrentPlayer().getPlace());
                System.out.println("The category is " + currentCategory().getName());
                askQuestion();
            } else {
                System.out.println(getCurrentPlayer().getPlayerName() + " is not getting out of the penalty box");
                getCurrentPlayer().gettingOutOfPenaltyBox();
            }
        } else {
            getCurrentPlayer().move(roll);
            System.out.println(getCurrentPlayer().getPlayerName()
                    + "'s new location is "
                    + getCurrentPlayer().getPlace());
            System.out.println("The category is " + currentCategory().getName());
            askQuestion();
        }
    }

    public boolean wasCorrectlyAnswered() {
        if (getCurrentPlayer().isInPenaltyBox()) {
            if (getCurrentPlayer().isGettingOutOfPenaltyBox()) {
                System.out.println("Answer was correct!!!!");
                getCurrentPlayer().addCoin();
                System.out.println(getCurrentPlayer().getPlayerName()
                        + " now has "
                        + getCurrentPlayer().getPurse()
                        + " Gold Coins.");

                boolean winner = getCurrentPlayer().didWin();
                moveToNextPlayer();
                return winner;
            } else {
                moveToNextPlayer();
                return true;
            }
        } else {
            System.out.println("Answer was correct!!!!");
            getCurrentPlayer().addCoin();
            System.out.println(getCurrentPlayer().getPlayerName()
                    + " now has "
                    + getCurrentPlayer().getPurse()
                    + " Gold Coins.");

            boolean winner = getCurrentPlayer().didWin();
            moveToNextPlayer();

            return winner;
        }
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(getCurrentPlayer().getPlayerName() + " was sent to the penalty box");
        getCurrentPlayer().moveToPenaltyBox();

        moveToNextPlayer();
        return true;
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    private void askQuestion() {
        questionCategories.ask(currentCategory());
    }

    private Category currentCategory() {
        return Category.getCategoryForPlayer(getCurrentPlayer());
    }

    private void moveToNextPlayer() {
        currentPlayer++;
        if (currentPlayer == getNumberOfPlayers()) {
            currentPlayer = 0;
        }
    }

    private int getNumberOfPlayers() {
        return players.size();
    }
}