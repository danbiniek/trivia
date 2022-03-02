package com.adaptionsoft.games.uglytrivia.answer;

import com.adaptionsoft.games.uglytrivia.Player;

record OutOfPenaltyCorrectAnswerProcessor(Player player) implements CorrectAnswerProcessor {

    @Override
    public boolean process() {
        System.out.println("Answer was correct!!!!");
        player.addCoin();
        System.out.println(player.getPlayerName() + " now has " + player.getPurse() + " Gold Coins.");
        return player.didWin();
    }
}
