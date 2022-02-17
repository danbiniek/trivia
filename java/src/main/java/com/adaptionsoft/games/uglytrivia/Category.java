package com.adaptionsoft.games.uglytrivia;

public enum Category {
    POP {
        @Override
        public String ask() {
            return question.askPopQuestion();
        }
    },
    SCIENCE {
        @Override
        public String ask() {
            return question.askScienceQuestion();
        }
    },
    SPORT {
        @Override
        public String ask() {
            return question.askSportQuestion();
        }
    },
    ROCK {
        @Override
        public String ask() {
            return question.askRockQuestion();
        }
    };

    private static final Question question = new Question();

    public abstract String ask();
}
