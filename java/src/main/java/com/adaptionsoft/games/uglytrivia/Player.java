package com.adaptionsoft.games.uglytrivia;

class Player {

    private final String playerName;
    private int place;
    private int purse;
    private boolean inPenaltyBox;

    public Player(String playerName) {
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

}
