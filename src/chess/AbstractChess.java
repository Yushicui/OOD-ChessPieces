/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

package chess;

import java.awt.*;

/**
 * Abstract class for all chess pieces.
 * It implements the ChessPiece interface.
 */
public abstract class AbstractChess implements ChessPiece {

  protected int row;
  protected int col;

  protected Color color;

  /**
   * Constructor for a chess piece, takes row, column, and color.
   *
   * @param row the row of the chess piece on the board.
   * @param col the column of the chess piece on the board.
   * @param color the color of the chess piece.
   * @throws IllegalArgumentException if the row or column values are not between 0 and 7.
   */
  public AbstractChess(int row, int col, Color color) {
    if(row > 7 || row < 0 || col > 7 || col < 0 ) {
      throw new IllegalArgumentException("Maximum numbers of column and row is 8.");
    }
    this.row = row;
    this.col = col;
    this.color = color;
  }

  /**
   * Return the current row of the chess piece.
   *
   * @return the row of the current piece.
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * Return the current column of the chess piece.
   *
   * @return the column of the current chess piece.
   */
  @Override
  public int getColumn() {
    return this.col;
  }

  /**
   * Get the color of the chess piece.
   *
   * @return the color of the chess piece (black or white).
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Determine if the chess piece can move to a given cell.
   *
   * @param row the row where the piece might be moved to.
   * @param col the column where the piece might be moved to.
   * @return True if the piece can move to that location. False otherwise.
   */
  @Override
  public boolean canMove(int row, int col) {
    if ((row == this.row && col == this.col) || (row > 7 || row < 0 || col > 7 || col < 0)) {
      return false;
    }
    return true;
  }

  /**
   * Determine of the piece can kill another piece starting from its current location.
   * @param piece the piece that might be killed.
   * @return True if the new piece can be killed.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    boolean canMove = this.canMove(piece.getRow(), piece.getColumn());
    boolean diffColor = this.getColor() != piece.getColor();
    return canMove && diffColor;
  }
}