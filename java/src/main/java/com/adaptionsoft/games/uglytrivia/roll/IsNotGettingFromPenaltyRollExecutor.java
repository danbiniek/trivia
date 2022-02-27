package com.adaptionsoft.games.uglytrivia.roll;

import com.adaptionsoft.games.uglytrivia.Player;

record IsNotGettingFromPenaltyRollExecutor(Player player) implements RollExecutor {

    @Override
    public void execute() {
        System.out.println(player.getPlayerName() + " is not getting out of the penalty box");
        player.gettingOutOfPenaltyBox();
    }
}
