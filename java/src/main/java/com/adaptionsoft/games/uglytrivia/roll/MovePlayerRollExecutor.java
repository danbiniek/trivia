package com.adaptionsoft.games.uglytrivia.roll;

import com.adaptionsoft.games.uglytrivia.Player;

record MovePlayerRollExecutor(int roll, Player player) implements RollExecutor {

    @Override
    public void execute() {
        player.move(roll);
        System.out.println(player.getPlayerName() + "'s new location is " + player.getPlace());
    }
}
