package com.adaptionsoft.games.uglytrivia;

import java.util.stream.Stream;

enum Category {
    POP("Pop", 0),
    SCIENCE("Science", 1),
    SPORTS("Sports", 2),
    ROCK("Rock", 3);

    Category(String name, int place) {
        this.name = name;
        this.place = place;
    }

    private final String name;
    private final int place;

    public String getName() {
        return name;
    }

    public static Category getCategoryForPlayer(Player aPlayer) {
        int modulo = aPlayer.getPlace() % values().length;
        return getCategory(modulo);
    }

    private static Category getCategory(int modulo) {
        return Stream.of(values())
                .filter(category -> category.place == modulo)
                .findFirst()
                .orElseThrow();
    }
}
