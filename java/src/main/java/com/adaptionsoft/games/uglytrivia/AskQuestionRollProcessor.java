package com.adaptionsoft.games.uglytrivia;

public record AskQuestionRollProcessor(Player player, QuestionCategories questionCategories) implements RollProcessor {

    public AskQuestionRollProcessor(Player player) {
        this(player, new QuestionCategories());
    }

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
