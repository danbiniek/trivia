package com.adaptionsoft.games.uglytrivia;

public record IsGettingFromPenaltyRollExecutor(Player player) implements RollExecutor {

    @Override
    public void execute() {
        player.gettingOutOfPenaltyBox();
        System.out.println(player.getPlayerName() + " is getting out of the penalty box");
    }
}
