package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionTest {

    @Test
    void aQuestions_shouldInitWith50Items_whenCreated() {
        var question = new Question();

        assertEquals(50, question.getPopQuestions().size());
        assertEquals(50, question.getScienceQuestions().size());
        assertEquals(50, question.getSportsQuestions().size());
        assertEquals(50, question.getRockQuestions().size());
    }

    @Test
    void aPopQuestion_shouldBeRemoved_whenAsked() {
        var question = new Question();

        question.askPopQuestion();

        assertEquals(49, question.getPopQuestions().size());
    }

    @Test
    void aScienceQuestion_shouldBeRemoved_whenAsked() {
        var question = new Question();

        question.askScienceQuestion();

        assertEquals(49, question.getScienceQuestions().size());
    }

    @Test
    void aSportQuestion_shouldBeRemoved_whenAsked() {
        var question = new Question();

        question.askSportQuestion();

        assertEquals(49, question.getSportsQuestions().size());
    }

    @Test
    void aRockQuestion_shouldBeRemoved_whenAsked() {
        var question = new Question();

        question.askRockQuestion();

        assertEquals(49, question.getRockQuestions().size());
    }

}
