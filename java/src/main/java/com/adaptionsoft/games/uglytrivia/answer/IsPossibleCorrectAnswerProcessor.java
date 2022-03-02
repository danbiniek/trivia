package com.adaptionsoft.games.uglytrivia.answer;

import com.adaptionsoft.games.uglytrivia.Player;

record IsPossibleCorrectAnswerProcessor(Player player) implements CorrectAnswerProcessor {

    @Override
    public boolean process() {
        System.out.println("Answer was correct!!!!");
        player.addCoin();
        return player.didWin();
    }
}
