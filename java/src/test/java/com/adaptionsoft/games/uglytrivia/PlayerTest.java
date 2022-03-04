package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void theNewPlayer_isCreatedWithCorrectName_whenNameIsCorrect() {
        Player result = Player.ofName("Test");

        assertEquals("Test", result.getPlayerName());
    }

    @Test
    void theNPE_isThrown_whenNameIsNull() {
        assertThrows(NullPointerException.class, () -> Player.ofName(null));
    }

    @Test
    void theIAE_isThrown_whenNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Player.ofName(""));
    }

    @Test
    void theIAE_isThrown_whenNameContainsOnlyWhiteChars() {
        assertThrows(IllegalArgumentException.class, () -> Player.ofName("    "));
    }

    @Test
    void aPlayerPlace_is0_whenNewPlayerIsCreated() {
        Player player = Player.ofName("test");

        assertEquals(0, player.getPlace());
    }

    @Test
    void aPlayerPlace_is1_whenPlayerMovedBy1() {
        Player player = Player.ofName("test");

        player.move(1);

        assertEquals(1, player.getPlace());
    }

    @Test
    void aPlayerPlace_is0_whenPlayerMovedBy12() {
        Player player = Player.ofName("test");

        player.move(12);

        assertEquals(0, player.getPlace());
    }

    @Test
    void aPlayerPurse_is0_whenNewPlayerIsCreated() {
        Player player = Player.ofName("test");

        assertEquals(0, player.getPurse());
    }

    @Test
    void aPlayerPurse_is1_whenCoinIsAdded() {
        Player player = Player.ofName("test");

        player.addCoin();

        assertEquals(1, player.getPurse());
    }

    @Test
    void aPlayer_didNotWin_whenNewPlayerIsCreated() {
        Player player = Player.ofName("test");

        assertFalse(player.didWin());
    }

    @Test
    void aPlayer_didNotWin_whenHasLessThen6Coins() {
        Player player = Player.ofName("test");

        player.addCoin();
        player.addCoin();
        player.addCoin();

        assertFalse(player.didWin());
    }

    @Test
    void aPlayer_didWin_whenPlayerHas6Coins() {
        Player player = Player.ofName("test");

        player.addCoin();
        player.addCoin();
        player.addCoin();
        player.addCoin();
        player.addCoin();
        player.addCoin();

        assertTrue(player.didWin());
    }

    @Test
    void aPlayer_isNotInPenaltyBox_whenNewPlayerIsCreated() {
        Player player = Player.ofName("test");

        assertFalse(player.isInPenaltyBox());
    }

    @Test
    void aPlayer_isInPenaltyBox_whenPlayerIsMovedToPenaltyBox() {
        Player player = Player.ofName("test");

        player.moveToPenaltyBox();

        assertTrue(player.isInPenaltyBox());
    }

    @Test
    void aPlayer_isNotGettingOutFromPenaltyBox_whenNewPlayerIsCreated() {
        Player player = Player.ofName("test");

        assertFalse(player.isGettingOutOfPenaltyBox());
    }


    @Test
    void aPlayer_isGettingOutFromPenaltyBox_whenPlayerMovingOutFromPenaltyBox() {
        Player player = Player.ofName("test");

        player.moveToPenaltyBox();
        player.gettingOutOfPenaltyBox();

        assertTrue(player.isInPenaltyBox());
    }
}