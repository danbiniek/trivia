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

    @Test
    void aPlayer_shouldNotWinaGame_whenHeAnswersIncorrectly() {
        var game = new Game();
        game.add("John");

        game.roll(1);
        var notAWinner = game.wrongAnswer();

        assertTrue(notAWinner);
    }

    @Test
    void aPlayer_shouldNotWinaGame_whenHeAnswersIncorrectlyMultipleTimes() {
        var game = new Game();
        game.add("John");

        game.roll(1);
        game.wrongAnswer();
        game.wrongAnswer();
        game.wrongAnswer();
        game.wrongAnswer();
        game.wrongAnswer();
        var notAWinner = game.wrongAnswer();

        assertTrue(notAWinner);
    }

    @Test
    void aPlayer_shouldWinaGame_whenHeAnswersCorrectly6timesButNotInARowAndIsNotInPenalty() {
        var game = new Game();
        game.add("John");

        game.roll(1);
        game.wrongAnswer();
        game.roll(1);
        game.wasCorrectlyAnswered();
        game.wrongAnswer();
        game.roll(1);
        game.wasCorrectlyAnswered();
        game.wrongAnswer();
        game.roll(1);
        game.wasCorrectlyAnswered();
        game.wasCorrectlyAnswered();
        game.wasCorrectlyAnswered();
        game.wrongAnswer();
        game.roll(1);
        game.wrongAnswer();
        game.roll(1);
        var notAWinner = game.wasCorrectlyAnswered();

        assertFalse(notAWinner);
    }

    @Test
    void aPlayer_shouldWinNotaGame_whenHeAnswersCorrectly6timesButNotInARowAndIsInPenalty() {
        var game = new Game();
        game.add("John");

        game.roll(1);
        game.wrongAnswer();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.wrongAnswer();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.wrongAnswer();
        game.wasCorrectlyAnswered();
        game.wasCorrectlyAnswered();
        game.wasCorrectlyAnswered();
        game.wrongAnswer();
        game.wrongAnswer();
        var notAWinner = game.wasCorrectlyAnswered();

        assertTrue(notAWinner);
    }
}
