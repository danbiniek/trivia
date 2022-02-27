package com.adaptionsoft.games.uglytrivia;

public record IsNotGettingFromPenaltyRollExecutor(Player player) implements RollExecutor {

    @Override
    public void execute() {
        System.out.println(player.getPlayerName() + " is not getting out of the penalty box");
        player.gettingOutOfPenaltyBox();
    }
}
