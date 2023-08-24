/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

package chess;

/**
 * The class of Knight chess piece.
 * It extends from the abstract class AbstractChess.
 */
public class Knight extends AbstractChess{

  /**
   * Constructor for a Knight chess piece.
   *
   * @param row the row of the Knight on the board.
   * @param col the column of the Knight on the board.
   * @param color the color of the Knight.
   */
  public Knight(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {

    if (!super.canMove(row, col)) {
      return false;
    }

    int rowDiff = Math.abs(row - this.row);
    int colDiff = Math.abs(col - this.col);
    if (rowDiff == 2 && colDiff == 1 ||
            rowDiff == 1 && colDiff == 2) {
      return true;
    }
    return false;
  }
}

