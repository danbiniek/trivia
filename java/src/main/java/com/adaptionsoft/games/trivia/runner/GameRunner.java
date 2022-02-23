
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;

import java.util.Random;


public class GameRunner {

    private static boolean didPlayerWin;

    public static void main(String[] args) {
        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        Random rand = new Random();

        do {
            aGame.roll(rand.nextInt(5) + 1);
            if (rand.nextInt(9) == 7) {
                didPlayerWin = aGame.wrongAnswer();
            } else {
                didPlayerWin = aGame.wasCorrectlyAnswered();
            }
        } while (!didPlayerWin);
    }
}
