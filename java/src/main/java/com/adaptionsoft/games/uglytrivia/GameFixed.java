package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.question.QuestionCategories;
import com.adaptionsoft.games.uglytrivia.roll.RollExecutorFactory;

import java.util.ArrayList;
import java.util.List;

public class GameFixed implements IGame {

    private final RollExecutorFactory rollProcessor;
    private final List<Player> players = new ArrayList();
    private int currentPlayer = 0;

    public GameFixed() {
        rollProcessor = new RollExecutorFactory(new QuestionCategories());
    }

    @Override
    public void add(String playerName) {
        players.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
    }

    @Override
    public void roll(int roll) {
        System.out.println(getPlayerName() + " is the current player");
        System.out.println("They have rolled a " + roll);
        rollProcessor.getRollExecutor(roll, getCurrentPlayer()).execute();
    }

    @Override
    public boolean wasCorrectlyAnswered() {
        if (getCurrentPlayer().isInPenaltyBox()) {
            if (getCurrentPlayer().isGettingOutOfPenaltyBox()) {
                System.out.println("Answer was correct!!!!");
                getCurrentPlayer().addCoin();
                System.out.println(getPlayerName() + " now has " + getCurrentPlayer().getPurse() + " Gold Coins.");

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
            System.out.println(getPlayerName() + " now has " + getCurrentPlayer().getPurse() + " Gold Coins.");

            boolean winner = getCurrentPlayer().didWin();
            moveToNextPlayer();

            return winner;
        }
    }

    @Override
    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(getPlayerName() + " was sent to the penalty box");
        getCurrentPlayer().moveToPenaltyBox();

        moveToNextPlayer();
        return true;
    }

    private String getPlayerName() {
        return getCurrentPlayer().getPlayerName();
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
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