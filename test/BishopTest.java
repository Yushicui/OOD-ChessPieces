/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import chess.Bishop;
import chess.ChessPiece;
import chess.Color;

/**
 * Junit tests for the Bishop class.
 */
class BishopTest {

  ChessPiece Bishop;

  @BeforeEach
  void setUp() {
    Bishop = new Bishop(1, 3, Color.BLACK);
  }

  /**
   * Tests the constructor of the Bishop class.
   */
  @Test
  void testConstructor() {
    assertThrows( IllegalArgumentException.class, () -> {
              new Bishop(9, 9, Color.BLACK);});
    assertThrows( IllegalArgumentException.class, () -> {
              new Bishop(-1, -1, Color.WHITE);});
    assertThrows( IllegalArgumentException.class, () -> {
              new Bishop(-1, -4, Color.BLACK);});
  }

  /**
   * Tests the getRow method of the Bishop class.
   */
  @Test
  void testGetRow() {
    assertEquals(1, Bishop.getRow());
  }

  /**
   * Tests the getColumn method of the Bishop class.
   */
  @Test
  void testGetColumn() {
    assertEquals(3, Bishop.getColumn());
  }

  /**
   * Tests the getColor method of the Bishop class.
   */
  @Test
  void testGetColor() {
    assertEquals(Color.BLACK, Bishop.getColor());
  }

  /**
   * Tests the canMove method of the Bishop class.
   */
  @Test
  void testCanMove() {
    assertTrue(Bishop.canMove(2, 4));
    assertTrue(Bishop.canMove(5, 7));
    assertFalse(Bishop.canMove(-1, 2));
    assertFalse(Bishop.canMove(4, 5));
  }

  /**
   * Tests the canKill method of the Bishop class.
   */
  @Test
  void testCanKill() {
    ChessPiece opponent1 = new chess.Queen(2, 4, Color.WHITE);
    assertTrue(Bishop.canKill(opponent1));
    ChessPiece opponent2 = new chess.King(5, 4, Color.WHITE);
    assertFalse(Bishop.canKill(opponent2));
    ChessPiece opponent3 = new chess.Pawn(3, 5, Color.BLACK);
    assertFalse(Bishop.canKill(opponent3));
  }
}