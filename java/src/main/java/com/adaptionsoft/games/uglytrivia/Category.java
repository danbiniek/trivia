package com.adaptionsoft.games.uglytrivia;

enum Category {
    POP("Pop"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    ROCK("Rock");

    Category(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }

    public static Category getCategoryForPlayer(Player aPlayer) {
        int modulo = aPlayer.getPlace() % values().length;
        return getCategory(modulo);
    }

    private static Category getCategory(int modulo) {
        return switch (modulo) {
            case 0 -> Category.POP;
            case 1 -> Category.SCIENCE;
            case 2 -> Category.SPORTS;
            case 3 -> Category.ROCK;
            default -> throw new UnsupportedOperationException();
        };
    }
}
