package com.adaptionsoft.games.uglytrivia.answer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StayInPenaltyCorrectAnswerProcessorTest {

    @Test
    void aProcessor_returnTrue_wheneverIsCalled() {
        var answerProcessor = new StayInPenaltyCorrectAnswerProcessor();

        var result = answerProcessor.process();

        assertTrue(result);
    }

}