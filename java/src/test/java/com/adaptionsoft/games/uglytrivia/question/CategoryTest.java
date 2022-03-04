package com.adaptionsoft.games.uglytrivia.question;

import com.adaptionsoft.games.uglytrivia.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 8, 12})
    void aPopCategory_isReturned_whenPlayerStayOnModulo0Place(int place) {
        var player = Player.ofName("Test");

        player.move(place);

        assertEquals(Category.POP, Category.getCategoryForPlayer(player));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 9})
    void aScienceCategory_isReturned_whenPlayerStayOnModulo1Place(int place) {
        var player = Player.ofName("Test");

        player.move(place);

        assertEquals(Category.SCIENCE, Category.getCategoryForPlayer(player));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 6, 10})
    void aSportsCategory_isReturned_whenPlayerStayOnModulo2Place(int place) {
        var player = Player.ofName("Test");

        player.move(place);

        assertEquals(Category.SPORTS, Category.getCategoryForPlayer(player));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 11})
    void aRockCategory_isReturned_whenPlayerStayOnModulo2Place(int place) {
        var player = Player.ofName("Test");

        player.move(place);

        assertEquals(Category.ROCK, Category.getCategoryForPlayer(player));
    }

    @Test
    void aPopName_isReturned() {
        assertEquals("Pop", Category.POP.getName());
    }

    @Test
    void aScienceName_isReturned() {
        assertEquals("Science", Category.SCIENCE.getName());
    }

    @Test
    void aSportsName_isReturned() {
        assertEquals("Sports", Category.SPORTS.getName());
    }

    @Test
    void aRockName_isReturned() {
        assertEquals("Rock", Category.ROCK.getName());
    }
}