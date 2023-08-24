/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import chess.Queen;
import chess.ChessPiece;
import chess.Color;

/**
 * Junit tests for the Queen class.
 */
class QueenTest {

  ChessPiece Queen;

  @BeforeEach
  void setUp() {
    Queen = new Queen(7, 5, Color.WHITE);
  }

  /**
   * Tests the constructor of the Queen class.
   */
  @Test
  void testConstructor() {
    assertThrows( IllegalArgumentException.class, () -> {
      new Queen(9, 9, Color.BLACK);});
    assertThrows( IllegalArgumentException.class, () -> {
      new Queen(-1, -1, Color.WHITE);});
    assertThrows( IllegalArgumentException.class, () -> {
      new Queen(-1, -4, Color.BLACK);});
  }

  /**
   * Tests the getRow method of the Queen class.
   */
  @Test
  void testGetRow() {
    assertEquals(7, Queen.getRow());
  }

  /**
   * Tests the getColumn method of the Queen class.
   */
  @Test
  void testGetColumn() {
    assertEquals(5, Queen.getColumn());
  }

  /**
   * Tests the getColor method of the Queen class.
   */
  @Test
   void testGetColor() {
    assertEquals(Color.WHITE, Queen.getColor());
  }

  /**
   * Tests the canMove method of the Queen class.
   */
  @Test
  void testCanMove() {
    assertTrue(Queen.canMove(5, 5));
    assertTrue(Queen.canMove(6, 4));
    assertTrue(Queen.canMove(7, 2));
    assertFalse(Queen.canMove(9, 0));
  }

  /**
   * Tests the canKill method of the Queen class.
   */
  @Test
  void testCanKill() {
    ChessPiece opponent1 = new chess.Bishop(1, 5, Color.BLACK);
    assertTrue(Queen.canKill(opponent1));
    ChessPiece opponent2 = new chess.Rook(6, 5, Color.WHITE);
    assertFalse(Queen.canKill(opponent2));
    ChessPiece opponent3 = new chess.Knight(2, 3, Color.BLACK);
    assertFalse(Queen.canKill(opponent3));
  }
}