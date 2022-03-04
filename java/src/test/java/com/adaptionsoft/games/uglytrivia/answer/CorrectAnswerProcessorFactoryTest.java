package com.adaptionsoft.games.uglytrivia.answer;

import com.adaptionsoft.games.uglytrivia.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CorrectAnswerProcessorFactoryTest {

    @Test
    void theIsPossibleProcessor_isReturn_whenNewPlayer() {
        var factory = new CorrectAnswerProcessorFactory();
        var player = Player.ofName("test");

        var result = factory.getProcessor(player);

        assertEquals(IsPossibleCorrectAnswerProcessor.class, result.getClass());
    }

    @Test
    void theIsPossibleProcessor_isReturn_whenPlayerIsNotInPenaltyBoxAndIsGettingOut() {
        var factory = new CorrectAnswerProcessorFactory();
        var player = Player.ofName("test");

        player.gettingOutOfPenaltyBox();
        var result = factory.getProcessor(player);

        assertEquals(IsPossibleCorrectAnswerProcessor.class, result.getClass());
    }

    @Test
    void theIsPossibleProcessor_isReturn_whenPlayerIsInPenaltyBoxAndIsGettingOut() {
        var factory = new CorrectAnswerProcessorFactory();
        var player = Player.ofName("test");

        player.moveToPenaltyBox();
        player.gettingOutOfPenaltyBox();
        var result = factory.getProcessor(player);

        assertEquals(IsPossibleCorrectAnswerProcessor.class, result.getClass());
    }

    @Test
    void theStayInPenaltyProcessor_isReturn_whenPlayerIsInPenaltyBoxAndIsNotGettingOut() {
        var factory = new CorrectAnswerProcessorFactory();
        var player = Player.ofName("test");

        player.moveToPenaltyBox();
        var result = factory.getProcessor(player);

        assertEquals(StayInPenaltyCorrectAnswerProcessor.class, result.getClass());
    }

}