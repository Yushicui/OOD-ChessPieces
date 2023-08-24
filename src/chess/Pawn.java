/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

package chess;

/**
 * The class of Pawn chess piece.
 * It extends from the abstract class AbstractChess.
 */
public class Pawn extends AbstractChess {

  private boolean firstMove;

  /**
   * Constructor for a Pawn chess piece.
   *
   * @param row the row of the Pawn on the board.
   * @param col the column of the Pawn on the board.
   * @param color the color of the Pawn.
   */
  public Pawn(int row, int col, Color color) {
    super(row, col, color);
    if (color == Color.WHITE && row < 1) {
      throw new IllegalArgumentException("White Pawn cannot in row less than 1");
    }
    if (color == Color.BLACK && row > 6) {
      throw new IllegalArgumentException("Black Pawn cannot in row greater than 6");
    }
    this.firstMove = (color == Color.WHITE && row == 1) || (color == Color.BLACK && row == 6);
  }


  @Override
  public boolean canMove(int row, int col) {

    if (!super.canMove(row, col)) {
      return false;
    }

    int rowDiff = Math.abs(row - this.row);
    int colDiff = Math.abs(col - this.col);

    if (colDiff != 0) {
      return false;
    }

    if (this.color == Color.WHITE) {
      if (this.row > row) {
        return false;
      }
      if (this.firstMove && rowDiff == 2) {
        this.firstMove = false;
        return true;
      }
      return rowDiff == 1;

    } else {
      if (this.row < row) {
        return false;
      }
      if (this.firstMove && rowDiff == 2) {
        this.firstMove = false;
        return true;
      }
      return rowDiff == 1;
      }
    }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.color == piece.getColor()) {
      return false;
    }
    int rowDiff = piece.getRow() - this.row;
    int colDiff = Math.abs(piece.getColumn() - this.col);
    if(this.color == Color.WHITE) {
      return rowDiff == 1 && colDiff == 1;
    } else {
      return rowDiff == -1 && colDiff == 1;
    }
  }
}

