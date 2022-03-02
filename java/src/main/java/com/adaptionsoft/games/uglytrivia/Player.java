package com.adaptionsoft.games.uglytrivia;

public class Player {

    private final String playerName;
    private int place;
    private int purse;
    private boolean inPenaltyBox;
    private boolean isGettingOutOfPenaltyBox;

    private Player(String playerName) {
        this.playerName = playerName;
    }

    public static Player ofName(String name) {
        return new Player(name);
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

    public int getPurse() {
        return purse;
    }

    public void addCoin() {
        purse++;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void moveToPenaltyBox() {
        inPenaltyBox = true;
    }

    public boolean isGettingOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }

    public void gettingOutOfPenaltyBox() {
        isGettingOutOfPenaltyBox = true;
    }

    public boolean didWin() {
        return purse == 6;
    }
}
