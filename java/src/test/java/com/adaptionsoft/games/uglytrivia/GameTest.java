package com.adaptionsoft.games.uglytrivia;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    private static boolean notAWinner;

    @Test
    void aFixedGame_haveToLogTheSameOutputAsOriginalGame() {
        for (int seed = 0; seed < 100; seed++) {
            String expected = redirectOutput(Game::new, seed);
            String actual = redirectOutput(GameFixed::new, seed);
            assertEquals(expected, actual, "Change detected for seed: " + seed);
        }
    }

    private String redirectOutput(Supplier<IGame> gameSupplier, int seed) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));

        runGame(gameSupplier, seed);

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        String content = buffer.toString();
        buffer.reset();

        return content;
    }

    private void runGame(Supplier<IGame> gameSupplier, int seed) {
        var game = gameSupplier.get();
        game.add("Chet");
        game.add("Pat");
        game.add("Sue");

        var rand = new Random(seed);
        do {
            int roll = rand.nextInt(5) + 1;
            game.roll(roll);

            int luckNumber = rand.nextInt(9);
            if (luckNumber == 7) {
                notAWinner = game.wrongAnswer();
            } else {
                notAWinner = game.wasCorrectlyAnswered();
            }
        } while (notAWinner);
    }
}
