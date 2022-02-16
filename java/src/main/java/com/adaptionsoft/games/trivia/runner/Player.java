package com.adaptionsoft.games.trivia.runner;

import java.util.Objects;

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

    public void movetoPenaltyBox() {
        this.isPenaltyBox = true;
    }

    public void move(int roll) {
        this.place += roll;
        if (this.place > 11) {
            this.place -= 12;
        }
    }

    public int getPlace() {
        return place;
    }

    public int getPurses() {
        return purses;
    }

    public void incrementPurses() {
        this.purses++;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Player) obj;
        return Objects.equals(this.name, that.name) &&
                this.place == that.place &&
                this.purses == that.purses &&
                this.isPenaltyBox == that.isPenaltyBox;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place, purses, isPenaltyBox);
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
