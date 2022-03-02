package com.adaptionsoft.games.uglytrivia.answer;

import com.adaptionsoft.games.uglytrivia.Player;

public class CorrectAnswerProcessorFactory {

    public CorrectAnswerProcessor getProcessor(Player player) {
        if (playerCannotGiveAnswer(player)) {
            return new StayInPenaltyCorrectAnswerProcessor();
        }
        return new IsPossibleCorrectAnswerProcessor(player);
    }

    private boolean playerCannotGiveAnswer(Player player) {
        return player.isInPenaltyBox() && !player.isGettingOutOfPenaltyBox();
    }
}
