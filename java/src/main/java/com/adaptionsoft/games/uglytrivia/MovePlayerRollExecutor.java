package com.adaptionsoft.games.uglytrivia;

public record MovePlayerRollExecutor(int roll, Player player) implements RollExecutor {

    @Override
    public void execute() {
        player.move(roll);
        System.out.println(player.getPlayerName() + "'s new location is " + player.getPlace());
    }
}
