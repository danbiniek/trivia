package com.adaptionsoft.games.uglytrivia.answer;

import com.adaptionsoft.games.uglytrivia.Player;

public class CorrectAnswerProcessorFactory {

    public CorrectAnswerProcessor getProcessor(Player player) {
        if (player.isInPenaltyBox()) {
            if (player.isGettingOutOfPenaltyBox()) {
                return new OutOfPenaltyCorrectAnswerProcessor(player);
            } else {
                return new StayInPenaltyCorrectAnswerProcessor();
            }
        } else {
            return new OutOfPenaltyCorrectAnswerProcessor(player);
        }
    }
}
