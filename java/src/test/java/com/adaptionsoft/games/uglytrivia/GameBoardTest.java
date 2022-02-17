package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    void aBoard_shouldBeInit_whenIsCreated() {
        var board = new GameBoard();

        assertEquals(12, board.getBoard().length);
    }

    @Test
    void aBoard_shouldAcceptNewPlayer() {
        var board = new GameBoard();

        board.addPlayer(new Player("test"));

        assertTrue(board.getPlayers().containsKey(new Player("test")));
    }

    @Test
    void aBoard_shouldAddNewPlayerAtFirstPosition() {
        var board = new GameBoard();

        Player testPlayer = new Player("test");
        board.addPlayer(testPlayer);

        assertEquals(0, board.getPlayers().get(testPlayer));
    }

    @Test
    void aPlayerPlace_shouldBeChanged_whenPlayerRolledADice() {
        var board = new GameBoard();

        Player testPlayer = new Player("test");
        board.addPlayer(testPlayer);
        board.movePlayer(testPlayer, 5);

        assertEquals(5, board.getPlayers().get(testPlayer));
    }

    @Test
    void aPlayerPlace_shouldBeChanged_whenPlayerRolledMoreThen11() {
        var board = new GameBoard();

        Player testPlayer = new Player("test");
        board.addPlayer(testPlayer);
        board.movePlayer(testPlayer, 13);

        assertEquals(1, board.getPlayers().get(testPlayer));
    }

    @Test
    void aBoard_shouldThrowException_whenPlayerAlreadyExist() {
        var board = new GameBoard();

        Player testPlayer = new Player("test");
        board.addPlayer(testPlayer);
        assertThrows(IllegalArgumentException.class,
                () -> board.addPlayer(testPlayer));
    }

    @Test
    void aBoard_shouldReturnPlayersPlaceCategory() {
        var board = new GameBoard();

        Player testPlayer = new Player("test");
        board.addPlayer(testPlayer);
        Category result = board.getCategory(testPlayer);

        assertEquals(Category.POP, result);
    }

    @Test
    void aBoard_shouldReturnPlayersPlaceCategory_whenHeIsOnOtherPlace() {
        var board = new GameBoard();

        Player testPlayer = new Player("test");
        board.addPlayer(testPlayer);
        board.movePlayer(testPlayer, 5);
        Category result = board.getCategory(testPlayer);

        assertEquals(Category.SCIENCE, result);
    }
}
