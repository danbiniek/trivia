package com.adaptionsoft.games.uglytrivia.answer;

record StayInPenaltyCorrectAnswerProcessor() implements CorrectAnswerProcessor {

    @Override
    public boolean process() {
        return true;
    }
}
