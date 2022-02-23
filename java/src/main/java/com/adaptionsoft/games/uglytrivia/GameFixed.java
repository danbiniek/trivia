package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GameFixed implements IGame {

    class Player {
        private final String playerName;
        private int place;

        Player(String playerName) {
            this.playerName = playerName;
        }

        public String getPlayerName() {
            return playerName;
        }

        public int getPlace() {
            return place;
        }

        public void move(int roll) {
            place += roll;
            if (place >= 12) {
                place -= 12;
            }
        }
    }


    private int[] purses = new int[6];
    private boolean[] inPenaltyBox = new boolean[6];
    private List<Player> players = new ArrayList();
    private Deque<String> popQuestions = new LinkedList();
    private Deque<String> scienceQuestions = new LinkedList();
    private Deque<String> sportsQuestions = new LinkedList();
    private Deque<String> rockQuestions = new LinkedList();
    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;

    public GameFixed() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean add(String playerName) {
        players.add(new Player(playerName));
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        System.out.println(getCurrentPlayer().getPlayerName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(getCurrentPlayer().getPlayerName() + " is getting out of the penalty box");
                getCurrentPlayer().move(roll);
                System.out.println(getCurrentPlayer().getPlayerName()
                        + "'s new location is "
                        + getCurrentPlayer().getPlace());
                System.out.println("The category is " + currentCategory());
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
            System.out.println("The category is " + currentCategory());
            askQuestion();
        }

    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    private void askQuestion() {
        if (currentCategory() == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }


    private String currentCategory() {
        if (getCurrentPlayer().getPlace() == 0) return "Pop";
        if (getCurrentPlayer().getPlace() == 4) return "Pop";
        if (getCurrentPlayer().getPlace() == 8) return "Pop";
        if (getCurrentPlayer().getPlace() == 1) return "Science";
        if (getCurrentPlayer().getPlace() == 5) return "Science";
        if (getCurrentPlayer().getPlace() == 9) return "Science";
        if (getCurrentPlayer().getPlace() == 2) return "Sports";
        if (getCurrentPlayer().getPlace() == 6) return "Sports";
        if (getCurrentPlayer().getPlace() == 10) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct!!!!");
                purses[currentPlayer]++;
                System.out.println(getCurrentPlayer().getPlayerName()
                        + " now has "
                        + purses[currentPlayer]
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
            purses[currentPlayer]++;
            System.out.println(getCurrentPlayer().getPlayerName()
                    + " now has "
                    + purses[currentPlayer]
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
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == getNumberOfPlayers()) currentPlayer = 0;
        return true;
    }


    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }
}