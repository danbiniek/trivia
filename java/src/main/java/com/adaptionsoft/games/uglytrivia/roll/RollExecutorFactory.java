package com.adaptionsoft.games.uglytrivia.roll;

import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.question.QuestionCategories;

public record RollExecutorFactory(QuestionCategories questionCategories) {

    public RollExecutor getRollExecutor(int roll, Player player) {
        //todo: first if always return false
        if (player.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                return new IsGettingFromPenaltyRollExecutor(player).andThen(moveAndAsk(roll, player));
            }
            return new IsNotGettingFromPenaltyRollExecutor(player);
        } else {
            return moveAndAsk(roll, player);
        }
    }

    private RollExecutor moveAndAsk(int roll, Player player) {
        return new MovePlayerRollExecutor(roll, player)
                .andThen(new AskQuestionRollExecutor(player, questionCategories));
    }

}
