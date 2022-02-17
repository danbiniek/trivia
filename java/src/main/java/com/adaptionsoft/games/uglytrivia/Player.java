package com.adaptionsoft.games.uglytrivia;

import java.util.Objects;

public final class Player {
    private final String name;
    private int purses;
    private boolean isPenaltyBox;

    public Player(String name) {
        this.name = name;
        this.purses = 0;
        this.isPenaltyBox = false;
    }

    public boolean isPenaltyBox() {
        return isPenaltyBox;
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

    public void incrementPurses() {
        this.purses++;
    }

    @Override
    public String toString() {
        return "Player[" +
                "name=" + name + ", " +
                "purses=" + purses + ", " +
                "isPenaltyBox=" + isPenaltyBox + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
