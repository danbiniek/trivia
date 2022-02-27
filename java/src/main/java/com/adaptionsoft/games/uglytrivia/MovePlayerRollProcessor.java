package com.adaptionsoft.games.uglytrivia;

public record MovePlayerRollProcessor(int roll, Player player) implements RollProcessor {

    @Override
    public void execute() {
        player.move(roll);
        System.out.println(player.getPlayerName() + "'s new location is " + player.getPlace());
    }
}
