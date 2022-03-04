package com.adaptionsoft.games.uglytrivia;

import java.util.Objects;

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
        Objects.requireNonNull(name);
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
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
        System.out.println(this.getPlayerName() + "'s new location is " + this.getPlace());
    }

    public int getPurse() {
        return purse;
    }

    public void addCoin() {
        purse++;
        System.out.println(this.getPlayerName() + " now has " + this.getPurse() + " Gold Coins.");
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
