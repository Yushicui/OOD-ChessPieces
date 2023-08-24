/**
 * CS5004 Project 2
 * Name: Yushi Cui
 */

package chess;

/**
 * The class of Bishop chess piece.
 * It extends from the abstract class AbstractChess.
 */
public class Bishop extends AbstractChess {

  /**
   * Constructor for a Bishop chess piece.
   *
   * @param row the row of the Bishop on the board.
   * @param col the column of the Bishop on the board.
   * @param color the color of the Bishop.
   */
  public Bishop(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {

    if (!super.canMove(row, col)) {
      return false;
    }

    int rowDiff = Math.abs(row - this.row);
    int colDiff = Math.abs(col - this.col);
    if (rowDiff == colDiff) {
        return true;
      }
    return false;
    }
  }





