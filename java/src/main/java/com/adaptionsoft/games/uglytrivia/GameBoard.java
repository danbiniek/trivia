package com.adaptionsoft.games.uglytrivia;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class GameBoard {

    private final Map<Player, Integer> players = new HashMap<>();
    private final Category[] board = new Category[12];

    public void addPlayer(Player player) {
        var doPlayerExist = players.containsKey(player);
        if (doPlayerExist) {
            throw new IllegalArgumentException("Player already exist");
        }
        players.put(player, 0);
    }

    public void movePlayer(Player player, int roll) {
        players.computeIfPresent(player, moveByRoll(roll));
    }

    private BiFunction<Player, Integer, Integer> moveByRoll(int roll) {
        return (key, place) -> {
            var newPlace = place + roll;
            if (newPlace > 11) {
                newPlace -= 12;
            }
            return newPlace;
        };
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public Category getCategory(Player player) {
        var place = players.get(player);
        return board[place];
    }

    public GameBoard() {
        board[0] = Category.POP;
        board[1] = Category.SCIENCE;
        board[2] = Category.SPORT;
        board[3] = Category.ROCK;
        board[4] = Category.POP;
        board[5] = Category.SCIENCE;
        board[6] = Category.SPORT;
        board[7] = Category.ROCK;
        board[8] = Category.POP;
        board[9] = Category.SCIENCE;
        board[10] = Category.SPORT;
        board[11] = Category.ROCK;
    }

    Category[] getBoard() {
        return board;
    }

    Map<Player, Integer> getPlayers() {
        return players;
    }
}
