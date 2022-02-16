package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void aPlayer_shouldBeInit_whenIsCreated() {
        var player = new Player("name");

        assertEquals("name", player.getName());
        assertEquals(0, player.getPlace());
        assertEquals(0, player.getPurses());
        assertFalse(player.isPenaltyBox());
    }

    @Test
    void aPlayer_shouldBeInit_whenIsCreatedWithoutName() {
        var player = new Player(null);

        assertNull(player.getName());
        assertEquals(0, player.getPlace());
        assertEquals(0, player.getPurses());
        assertFalse(player.isPenaltyBox());
    }

    @Test
    void aPlayer_shouldBeInit_whenIsCreatedWithEmptyName() {
        var player = new Player("");

        assertEquals("", player.getName());
        assertEquals(0, player.getPlace());
        assertEquals(0, player.getPurses());
        assertFalse(player.isPenaltyBox());
    }

    @Test
    void aPlayer_shouldMoveByRoll() {
        var player = new Player("name");

        player.move(1);

        assertEquals(1, player.getPlace());
    }

    @Test
    void aPlayer_shouldResetPlace_whenRollIsEqualsThen12() {
        var player = new Player("name");

        player.move(12);

        assertEquals(0, player.getPlace());
    }

    @Test
    void aPlayer_shouldResetPlaceAndMoveFromStart_whenRollIsGraterThen12() {
        var player = new Player("name");

        player.move(15);

        assertEquals(3, player.getPlace());
    }

    @Test
    void aPlayer_shouldBeMoveToPenaltyBox_whenHeIsNotInPenalty() {
        var player = new Player("name");

        player.movetoPenaltyBox();

        assertTrue(player.isPenaltyBox());
    }

    @Test
    void aPlayer_shouldBeMoveToPenaltyBox_whenHeIsInPenalty() {
        var player = new Player("name");

        player.movetoPenaltyBox();
        player.movetoPenaltyBox();

        assertTrue(player.isPenaltyBox());
    }

    @Test
    void aPlayer_shouldBeMoveOutFromPenaltyBox_whenHeIsInPenalty() {
        var player = new Player("name");

        player.movetoPenaltyBox();
        player.moveOutFromPenaltyBox();

        assertFalse(player.isPenaltyBox());
    }

    @Test
    void aPlayer_shouldBeMoveOutFromPenaltyBox_whenHeIsNotInPenalty() {
        var player = new Player("name");

        player.moveOutFromPenaltyBox();
        player.moveOutFromPenaltyBox();

        assertFalse(player.isPenaltyBox());
    }

    @Test
    void aPlayer_shouldIncrementPursesBy1_whenIncrementIsCalledOnce() {
        var player = new Player("name");

        player.incrementPurses();

        assertEquals(1, player.getPurses());
    }

    @Test
    void aPlayer_shouldIncrementPursesByMultiple_whenIncrementIsCalledMultipleTimes() {
        var player = new Player("name");

        player.incrementPurses();
        player.incrementPurses();
        player.incrementPurses();

        assertEquals(3, player.getPurses());
    }


}
