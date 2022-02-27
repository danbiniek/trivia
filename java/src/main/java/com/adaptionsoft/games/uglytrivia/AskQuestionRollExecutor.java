package com.adaptionsoft.games.uglytrivia;

public record AskQuestionRollExecutor(Player player, QuestionCategories questionCategories) implements RollExecutor {

    @Override
    public void execute() {
        System.out.println("The category is " + currentCategory().getName());
        askQuestion();
    }

    private Category currentCategory() {
        return Category.getCategoryForPlayer(player);
    }

    private void askQuestion() {
        questionCategories.ask(currentCategory());
    }
}
