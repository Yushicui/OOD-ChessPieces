/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import chess.Pawn;
import chess.ChessPiece;
import chess.Color;

/**
 * Junit tests for the Pawn class.
 */
class PawnTest {

  ChessPiece whitePawn;
  ChessPiece blackPawn;

  @BeforeEach
  void setUp() {
    whitePawn = new Pawn(1, 4, Color.WHITE);
    blackPawn = new Pawn(6, 2, Color.BLACK);
  }

  /**
   * Tests the constructor of the Pawn class.
   */
  @Test
  void testConstructor() {
    assertThrows( IllegalArgumentException.class, () -> {
      new Pawn(9, 9, Color.BLACK);});
    assertThrows( IllegalArgumentException.class, () -> {
      new Pawn(-1, -1, Color.WHITE);});
    assertThrows( IllegalArgumentException.class, () -> {
      new Pawn(-1, -4, Color.BLACK);});
  }

  /**
   * Tests the getRow method of the Pawn class.
   */
  @Test
  void testGetRow() {
    assertEquals(1, whitePawn.getRow());
  }

  /**
   * Tests the getColumn method of the Pawn class.
   */
  @Test
  void testGetColumn() {
    assertEquals(4, whitePawn.getColumn());
  }

  /**
   * Tests the getColor method of the Pawn class.
   */
  @Test
  void testGetColor() {
    assertEquals(Color.WHITE, whitePawn.getColor());
    assertEquals(Color.BLACK, blackPawn.getColor());
  }

  /**
   * Tests the canMove method of the Pawn class.
   */
  @Test
  void testCanMove() {
    assertTrue(whitePawn.canMove(2, 4));
    assertTrue(whitePawn.canMove(3, 4));
    assertFalse(whitePawn.canMove(4, 5));
    assertFalse(whitePawn.canMove(1, 4));
    assertTrue(blackPawn.canMove(4, 2));
    assertTrue(blackPawn.canMove(5, 2));
    assertFalse(blackPawn.canMove(5, 3));
    assertFalse(blackPawn.canMove(4, -1));
  }

  /**
   * Tests the canKill method of the Pawn class.
   */
  @Test
  void testCanKill() {
    ChessPiece opponent1 = new chess.Bishop(2, 5, Color.BLACK);
    assertTrue(whitePawn.canKill(opponent1));
    ChessPiece opponent2 = new Pawn(4, 6, Color.BLACK);
    assertFalse(whitePawn.canKill(opponent2));
    ChessPiece opponent3 = new chess.Rook(5, 1, Color.WHITE);
    assertTrue(blackPawn.canKill(opponent3));
    ChessPiece opponent4 = new chess.King(4, 1, Color.WHITE);
    assertFalse(blackPawn.canKill(opponent4));
  }
}