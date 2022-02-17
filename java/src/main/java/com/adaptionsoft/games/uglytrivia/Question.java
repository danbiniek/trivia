package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question {

    private final Deque<String> popQuestions = new ArrayDeque<>();
    private final Deque<String> scienceQuestions = new ArrayDeque<>();
    private final Deque<String> sportsQuestions = new ArrayDeque<>();
    private final Deque<String> rockQuestions = new ArrayDeque<>();

    public Question() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    Deque<String> getPopQuestions() {
        return this.popQuestions;
    }

    Deque<String> getScienceQuestions() {
        return this.scienceQuestions;
    }

    Deque<String> getSportsQuestions() {
        return this.sportsQuestions;
    }

    Deque<String> getRockQuestions() {
        return this.rockQuestions;
    }

    public String askPopQuestion() {
        return this.popQuestions.removeFirst();
    }

    public String askScienceQuestion() {
        return this.scienceQuestions.removeFirst();
    }

    public String askSportQuestion() {
        return this.sportsQuestions.removeFirst();
    }

    public String askRockQuestion() {
        return this.rockQuestions.removeFirst();
    }
}
