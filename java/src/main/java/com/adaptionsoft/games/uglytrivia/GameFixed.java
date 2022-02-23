package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class GameFixed implements IGame {

    private boolean isGettingOutOfPenaltyBox;
    private int currentPlayer = 0;
    private List<Player> players = new ArrayList();

    private List<String> popQuestions = new ArrayList<>();
    private List<String> scienceQuestions = new ArrayList<>();
    private List<String> sportsQuestions = new ArrayList<>();
    private List<String> rockQuestions = new ArrayList<>();

    public GameFixed() {
        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add(("Science Question " + i));
            sportsQuestions.add(("Sports Question " + i));
            rockQuestions.add("Rock Question " + i);
        }
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
                isGettingOutOfPenaltyBox = true;

                System.out.println(getCurrentPlayer().getPlayerName() + " is getting out of the penalty box");
                getCurrentPlayer().move(roll);
                System.out.println(getCurrentPlayer().getPlayerName()
                        + "'s new location is "
                        + getCurrentPlayer().getPlace());
                System.out.println("The category is " + currentCategory().getName());
                askQuestion();
            } else {
                System.out.println(getCurrentPlayer().getPlayerName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
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

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    private void askQuestion() {
        switch (currentCategory()) {
            case POP:
                System.out.println(popQuestions.remove(0));
                break;
            case SCIENCE:
                System.out.println(scienceQuestions.remove(0));
                break;
            case SPORTS:
                System.out.println(sportsQuestions.remove(0));
                break;
            case ROCK:
                System.out.println(rockQuestions.remove(0));
                break;
        }
    }

    enum Category {
        POP("Pop"),
        SCIENCE("Science"),
        SPORTS("Sports"),
        ROCK("Rock");

        Category(String name) {
            this.name = name;
        }

        private final String name;

        public String getName() {
            return name;
        }
    }


    private Category currentCategory() {
        int modulo = getCurrentPlayer().getPlace() % 4;
        switch (modulo) {
            case 0:
                return Category.POP;
            case 1:
                return Category.SCIENCE;
            case 2:
                return Category.SPORTS;
            case 3:
                return Category.ROCK;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public boolean wasCorrectlyAnswered() {
        if (getCurrentPlayer().isInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct!!!!");
                getCurrentPlayer().addCoin();
                System.out.println(getCurrentPlayer().getPlayerName()
                        + " now has "
                        + getCurrentPlayer().getPurse()
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                currentPlayer++;
                if (currentPlayer == getNumberOfPlayers()) currentPlayer = 0;

                return winner;
            } else {
                currentPlayer++;
                if (currentPlayer == getNumberOfPlayers()) currentPlayer = 0;
                return true;
            }
        } else {
            System.out.println("Answer was corrent!!!!");
            getCurrentPlayer().addCoin();
            System.out.println(getCurrentPlayer().getPlayerName()
                    + " now has "
                    + getCurrentPlayer().getPurse()
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == getNumberOfPlayers()) currentPlayer = 0;

            return winner;
        }
    }

    private int getNumberOfPlayers() {
        return players.size();
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(getCurrentPlayer().getPlayerName() + " was sent to the penalty box");
        getCurrentPlayer().moveToPenaltyBox();

        currentPlayer++;
        if (currentPlayer == getNumberOfPlayers()) currentPlayer = 0;
        return true;
    }


    private boolean didPlayerWin() {
        return !(getCurrentPlayer().getPurse() == 6);
    }
}