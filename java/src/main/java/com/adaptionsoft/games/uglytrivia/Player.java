package com.adaptionsoft.games.uglytrivia;

public final class Player {
    private final String name;
    private int place;
    private int purses;
    private boolean isPenaltyBox;

    public Player(String name) {
        this.name = name;
        this.place = 0;
        this.purses = 0;
        this.isPenaltyBox = false;
    }

    public boolean isPenaltyBox() {
        return isPenaltyBox;
    }

    public int getPlace() {
        return place;
    }

    public int getPurses() {
        return purses;
    }

    public String getName() {
        return name;
    }

    public void movetoPenaltyBox() {
        this.isPenaltyBox = true;
    }

    public void moveOutFromPenaltyBox() {
        this.isPenaltyBox = false;
    }

    public void move(int roll) {
        this.place += roll;
        if (this.place > 11) {
            this.place -= 12;
        }
    }

    public void incrementPurses() {
        this.purses++;
    }

    @Override
    public String toString() {
        return "Player[" +
                "name=" + name + ", " +
                "place=" + place + ", " +
                "purses=" + purses + ", " +
                "isPenaltyBox=" + isPenaltyBox + ']';
    }


}
