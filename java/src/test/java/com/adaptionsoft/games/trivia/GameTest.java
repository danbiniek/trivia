package com.adaptionsoft.games.trivia;


import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void aPlayer_shouldWinaGame_whenHeGive6CorrectAnswers() {
        var game = new Game();
        game.add("John");

        game.roll(1);
        game.wasCorrectlyAnswered();
        game.wasCorrectlyAnswered();
        game.wasCorrectlyAnswered();
        game.wasCorrectlyAnswered();
        game.wasCorrectlyAnswered();
        var notAWinner = game.wasCorrectlyAnswered();

        assertFalse(notAWinner);
    }

    @Test
    void aPlayer_shouldNotWinaGame_untilHeAnswers6TimesCorrectly() {
        var game = new Game();
        game.add("John");

        game.roll(1);
        var notAWinner = game.wasCorrectlyAnswered();

        assertTrue(notAWinner);
    }
}
