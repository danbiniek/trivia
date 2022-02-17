package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CategoryTest {

    @Test
    void aCategory_shouldReturnSinglePopQuestion() {
        var question = Category.POP.ask();

        assertTrue(question.contains("Pop Question"));
    }

    @Test
    void aCategory_shouldReturnSingleScienceQuestion() {
        var question = Category.SCIENCE.ask();

        assertTrue(question.contains("Science Question"));
    }

    @Test
    void aCategory_shouldReturnSingleSportQuestion() {
        var question = Category.SPORT.ask();

        assertTrue(question.contains("Sports Question"));
    }

    @Test
    void aCategory_shouldReturnSingleRockQuestion() {
        var question = Category.ROCK.ask();

        assertTrue(question.contains("Rock Question"));
    }

}
