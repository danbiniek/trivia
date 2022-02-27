package com.adaptionsoft.games.uglytrivia.roll;

import com.adaptionsoft.games.uglytrivia.Player;

record IsGettingFromPenaltyRollExecutor(Player player) implements RollExecutor {

    @Override
    public void execute() {
        player.gettingOutOfPenaltyBox();
        System.out.println(player.getPlayerName() + " is getting out of the penalty box");
    }
}
