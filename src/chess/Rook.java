/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

package chess;

/**
 * The class of Rook chess piece.
 * It extends from the abstract class AbstractChess.
 */
public class Rook extends AbstractChess{

  /**
   * Constructor for a Rook chess piece.
   *
   * @param row the row of the Rook on the board.
   * @param col the column of the Rook on the board.
   * @param color the color of the Rook.
   */
  public Rook(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {

    if (!super.canMove(row, col)) {
      return false;
    }

    int rowDiff = Math.abs(row - this.row);
    int colDiff = Math.abs(col - this.col);
    if (rowDiff == 0 || colDiff == 0) {
      return true;
    }
    return false;
  }
}
