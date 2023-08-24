/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

package chess;

/**
 * The class of King chess piece.
 * It extends from the abstract class AbstractChess.
 */
public class King extends AbstractChess{

  /**
   * Constructor for a King chess piece.
   *
   * @param row the row of the King on the board.
   * @param col the column of the King on the board.
   * @param color the color of the King.
   */
  public King(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {

    if (!super.canMove(row, col)) {
      return false;
    }

    int rowDiff = Math.abs(row - this.row);
    int colDiff = Math.abs(col - this.col);
    if (rowDiff == 1 && colDiff == 0 ||
            rowDiff == 0 && colDiff == 1 ||
            rowDiff == 1 && colDiff == 1) {
      return true;
    }
    return false;
  }
}
