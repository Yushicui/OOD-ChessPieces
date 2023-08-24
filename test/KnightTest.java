/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import chess.Knight;
import chess.ChessPiece;
import chess.Color;

/**
 * Junit tests for the Knight class.
 */

class KnightTest {
  ChessPiece Knight;

  @BeforeEach
  void setUp() {
    Knight = new Knight(6, 2, Color.BLACK);
  }

  /**
   * Tests the constructor of the Knight class.
   */
  @Test
  void testConstructor() {
    assertThrows( IllegalArgumentException.class, () -> {
      new Knight(9, 9, Color.BLACK);});
    assertThrows( IllegalArgumentException.class, () -> {
      new Knight(-1, -1, Color.WHITE);});
    assertThrows( IllegalArgumentException.class, () -> {
      new Knight(-1, -4, Color.BLACK);});
  }

  /**
   * Tests the getRow method of the Knight class.
   */
  @Test
  void testGetRow() {
    assertEquals(6, Knight.getRow());
  }

  /**
   * Tests the getColumn method of the Knight class.
   */
  @Test
  void testGetColumn() {
    assertEquals(2, Knight.getColumn());
  }

  /**
   * Tests the getColor method of the Knight class.
   */
  @Test
  void testGetColor() {
    assertEquals(Color.BLACK, Knight.getColor());
  }

  /**
   * Tests the canMove method of the Knight class.
   */
  @Test
  void testCanMove() {
    assertTrue(Knight.canMove(7, 4));
    assertTrue(Knight.canMove(4, 3));
    assertFalse(Knight.canMove(7, -1));
    assertFalse(Knight.canMove(5, 3));
  }

  /**
   * Tests the canKill method of the Knight class.
   */
  @Test
  void testCanKill() {
    ChessPiece opponent1 = new chess.Bishop(4, 1, Color.WHITE);
    assertTrue(Knight.canKill(opponent1));
    ChessPiece opponent2 = new chess.Rook(4, 1, Color.BLACK);
    assertFalse(Knight.canKill(opponent2));
    ChessPiece opponent3 = new chess.Queen(5, 6, Color.WHITE);
    assertFalse(Knight.canKill(opponent3));
  }
}