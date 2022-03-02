
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.OriginalGame;

import java.util.Random;


public class GameRunner {

    private static boolean didPlayerWin;

    public static void main(String[] args) {
        OriginalGame originalGame = new OriginalGame();

        originalGame.add("Chet");
        originalGame.add("Pat");
        originalGame.add("Sue");

        Random rand = new Random();

        do {
            originalGame.roll(rand.nextInt(5) + 1);
            if (rand.nextInt(9) == 7) {
                didPlayerWin = originalGame.wrongAnswer();
            } else {
                didPlayerWin = originalGame.wasCorrectlyAnswered();
            }
        } while (!didPlayerWin);
    }
}
