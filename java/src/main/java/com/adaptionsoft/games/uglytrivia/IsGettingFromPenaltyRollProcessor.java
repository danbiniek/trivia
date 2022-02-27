package com.adaptionsoft.games.uglytrivia;

public record IsGettingFromPenaltyRollProcessor(Player player) implements RollProcessor {

    @Override
    public void execute() {
        player.gettingOutOfPenaltyBox();
        System.out.println(player.getPlayerName() + " is getting out of the penalty box");
    }
}
