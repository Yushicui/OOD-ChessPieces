/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import chess.Rook;
import chess.ChessPiece;
import chess.Color;

/**
 * Junit tests for the Rook class.
 */
class RookTest {

  ChessPiece Rook;

  @BeforeEach
  void setUp() {
    Rook = new Rook(5, 3, Color.BLACK);
  }

  /**
   * Tests the constructor of the Rook class.
   */
  @Test
  void testConstructor() {
    assertThrows( IllegalArgumentException.class, () -> {
      new Rook(9, 9, Color.BLACK);});
    assertThrows( IllegalArgumentException.class, () -> {
      new Rook(-1, -1, Color.WHITE);});
    assertThrows( IllegalArgumentException.class, () -> {
      new Rook(-1, -4, Color.BLACK);});
  }

  /**
   * Tests the getRow method of the Rook class.
   */
  @Test
  void testGetRow() {
    assertEquals(5, Rook.getRow());
  }

  /**
   * Tests the getColumn method of the Rook class.
   */
  @Test
  void testGetColumn() {
    assertEquals(3, Rook.getColumn());
  }

  /**
   * Tests the getColor method of the Rook class.
   */
  @Test
  void testGetColor() {
    assertEquals(Color.BLACK, Rook.getColor());
  }

  /**
   * Tests the canMove method of the Rook class.
   */
  @Test
  void testCanMove() {
    assertTrue(Rook.canMove(7, 3));
    assertTrue(Rook.canMove(5, 2));
    assertFalse(Rook.canMove(5, 3));
    assertFalse(Rook.canMove(-1, 4));
  }

  /**
   * Tests the canKill method of the Rook class.
   */
  @Test
  void testCanKill() {
    ChessPiece opponent1 = new chess.Bishop(4, 3, Color.WHITE);
    assertTrue(Rook.canKill(opponent1));
    ChessPiece opponent2 = new chess.Queen(5, 5, Color.BLACK);
    assertFalse(Rook.canKill(opponent2));
    ChessPiece opponent3 = new chess.Knight(4, 6, Color.WHITE);
    assertFalse(Rook.canKill(opponent3));
  }
}