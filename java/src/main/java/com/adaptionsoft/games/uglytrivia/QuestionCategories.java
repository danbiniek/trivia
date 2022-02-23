package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

class QuestionCategories {

    private Map<Category, List<String>> questions = new EnumMap<>(Category.class);

    public QuestionCategories() {
        initQuestions();
        for (int i = 0; i < 50; i++) {
            int index = i;
            questions.computeIfPresent(Category.POP, addQuestions("Pop Question " + index));
            questions.computeIfPresent(Category.SCIENCE, addQuestions("Science Question " + index));
            questions.computeIfPresent(Category.SPORTS, addQuestions("Sports Question " + index));
            questions.computeIfPresent(Category.ROCK, addQuestions("Rock Question " + index));
        }
    }

    private void initQuestions() {
        Stream.of(Category.values()).forEach(category -> questions.put(category, new ArrayList<>()));
    }

    private BiFunction<Category, List<String>, List<String>> addQuestions(String question) {
        return (k, v) -> addQuestion(v, question);
    }

    private List<String> addQuestion(List<String> currentQuestions, String newQuestion) {
        currentQuestions.add(newQuestion);
        return currentQuestions;
    }

    public void ask(Category category) {
        System.out.println(questions.get(category).remove(0));
    }
}
