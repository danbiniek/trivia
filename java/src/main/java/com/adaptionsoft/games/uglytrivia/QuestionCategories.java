package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

class QuestionCategories {
    private List<String> popQuestions = new ArrayList<>();
    private List<String> scienceQuestions = new ArrayList<>();
    private List<String> sportsQuestions = new ArrayList<>();
    private List<String> rockQuestions = new ArrayList<>();

    public QuestionCategories() {
        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add(("Science Question " + i));
            sportsQuestions.add(("Sports Question " + i));
            rockQuestions.add("Rock Question " + i);
        }
    }

    public void ask(Category category) {
        switch (category) {
            case POP:
                System.out.println(popQuestions.remove(0));
                break;
            case SCIENCE:
                System.out.println(scienceQuestions.remove(0));
                break;
            case SPORTS:
                System.out.println(sportsQuestions.remove(0));
                break;
            case ROCK:
                System.out.println(rockQuestions.remove(0));
                break;
        }
    }
}
