package com.adaptionsoft.games.uglytrivia.roll;

import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.question.Category;
import com.adaptionsoft.games.uglytrivia.question.QuestionCategories;

record AskQuestionRollExecutor(Player player, QuestionCategories questionCategories) implements RollExecutor {

    @Override
    public void execute() {
        askQuestion();
    }

    private Category currentCategory() {
        var categoryForPlayer = Category.getCategoryForPlayer(player);
        System.out.println("The category is " + categoryForPlayer.getName());
        return categoryForPlayer;
    }

    private void askQuestion() {
        System.out.println(questionCategories.getQuestion(currentCategory()));
    }
}
