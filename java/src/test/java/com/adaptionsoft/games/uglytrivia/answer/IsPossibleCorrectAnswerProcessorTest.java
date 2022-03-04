package com.adaptionsoft.games.uglytrivia.answer;

import com.adaptionsoft.games.uglytrivia.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPossibleCorrectAnswerProcessorTest {

    @Test
    void aPlayer_shouldGotOneMoreCoinAndNotWin_whenProcessorIsCalledSingleTime() {
        var player = Player.ofName("test");
        var answerProcessor = new IsPossibleCorrectAnswerProcessor(player);

        var result = answerProcessor.process();

        assertFalse(result);
        assertEquals(1, player.getPurse());
    }

    @Test
    void aPlayer_shouldWin_whenProcessorIsCalled6thTime() {
        var player = Player.ofName("test");
        var answerProcessor = new IsPossibleCorrectAnswerProcessor(player);

        answerProcessor.process();
        answerProcessor.process();
        answerProcessor.process();
        answerProcessor.process();
        answerProcessor.process();
        var result = answerProcessor.process();

        assertTrue(result);
    }
}