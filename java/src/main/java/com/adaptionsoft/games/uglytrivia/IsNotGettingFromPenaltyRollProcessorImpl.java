package com.adaptionsoft.games.uglytrivia;

public record IsNotGettingFromPenaltyRollProcessorImpl(Player player) implements RollProcessor {

    @Override
    public void execute() {
        System.out.println(player.getPlayerName() + " is not getting out of the penalty box");
        player.gettingOutOfPenaltyBox();
    }
}
