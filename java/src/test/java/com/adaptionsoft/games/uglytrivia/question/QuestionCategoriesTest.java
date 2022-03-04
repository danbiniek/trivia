package com.adaptionsoft.games.uglytrivia.question;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionCategoriesTest {

    @Test
    void aPopQuestion_isReturned_whenAskedAboutPopCategory() {
        var questionsCategory = new QuestionCategories();

        String result = questionsCategory.getQuestion(Category.POP);

        assertTrue(result.contains("Pop"));
    }

    @Test
    void aScienceQuestion_isReturned_whenAskedAboutScienceCategory() {
        var questionsCategory = new QuestionCategories();

        String result = questionsCategory.getQuestion(Category.SCIENCE);

        assertTrue(result.contains("Science"));
    }

    @Test
    void aSportQuestion_isReturned_whenAskedAboutSportCategory() {
        var questionsCategory = new QuestionCategories();

        String result = questionsCategory.getQuestion(Category.SPORTS);

        assertTrue(result.contains("Sport"));
    }

    @Test
    void aRockQuestion_isReturned_whenAskedAboutRockCategory() {
        var questionsCategory = new QuestionCategories();

        String result = questionsCategory.getQuestion(Category.ROCK);

        assertTrue(result.contains("Rock"));
    }

}