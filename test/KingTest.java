/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.King;
import chess.ChessPiece;
import chess.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit tests for the King class.
 */
class KingTest {

  ChessPiece King;

  @BeforeEach
  void setUp() {
    King = new King(4, 5, Color.WHITE);
  }

  /**
   * Tests the constructor of the King class.
   */
  @Test
  void testConstructor() {
    assertThrows( IllegalArgumentException.class, () -> {
      new King(9, 9, Color.BLACK);});
    assertThrows( IllegalArgumentException.class, () -> {
      new King(-1, -1, Color.WHITE);});
    assertThrows( IllegalArgumentException.class, () -> {
      new King(-1, -4, Color.BLACK);});
  }

  /**
   * Tests the getRow method of the King class.
   */
  @Test
  void testGetRow() {
    assertEquals(4, King.getRow());
  }

  /**
   * Tests the getColumn method of the King class.
   */
  @Test
  void testGetColumn() {
    assertEquals(5, King.getColumn());
  }

  /**
   * Tests the getColor method of the King class.
   */
  @Test
  void testGetColor() {
    assertEquals(Color.WHITE, King.getColor());
  }

  /**
   * Tests the canMove method of the King class.
   */
  @Test
  void testCanMove() {
    assertTrue(King.canMove(3, 5));
    assertTrue(King.canMove(3, 4));
    assertFalse(King.canMove(6, 5));
    assertFalse(King.canMove(0, 2));
  }

  /**
   * Tests the canKill method of the King class.
   */
  @Test
  void testCanKill() {
    ChessPiece opponent1 = new chess.Queen(3, 4, Color.BLACK);
    assertTrue(King.canKill(opponent1));
    ChessPiece opponent2 = new chess.Pawn(6, 7, Color.BLACK);
    assertFalse(King.canKill(opponent2));
    ChessPiece opponent3 = new chess.Bishop(5, 5, Color.WHITE);
    assertFalse(King.canKill(opponent3));
  }
}