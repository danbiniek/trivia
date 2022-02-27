package com.adaptionsoft.games.uglytrivia;

public record RollProcessorFactory(QuestionCategories questionCategories) {

    public RollProcessor getProcessor(int roll, Player player) {
        //todo: first if always return false
        if (player.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                return new IsGettingFromPenaltyRollProcessor(player).andThen(moveAndAsk(roll, player));
            }
            return new IsNotGettingFromPenaltyRollProcessorImpl(player);
        } else {
            return moveAndAsk(roll, player);
        }
    }

    private RollProcessor moveAndAsk(int roll, Player player) {
        return new MovePlayerRollProcessor(roll, player)
                .andThen(new AskQuestionRollProcessor(player, questionCategories));
    }

}
