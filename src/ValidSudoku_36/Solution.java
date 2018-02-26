package ValidSudoku_36;

import java.util.HashSet;
import java.util.Set;

// 这道题的解法巧在无需给i，j一个固定死板的定义
// 注意到9行9列且有9个cube
// i，j在循环内，可以代表rowNum, colNum.也可以用来扫cubes
// 只要我们能扫完整个matrix，就行！
public class Solution {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      Set<Character> rows = new HashSet<Character>();
      Set<Character> columns = new HashSet<Character>();
      Set<Character> cube = new HashSet<Character>();
      for (int j = 0; j < 9; j++) {
        // here, i means rows, j means cols
        if (board[i][j] != '.' && !rows.add(board[i][j]))
          return false;
        // here, j means rows, i meas cols
        if (board[j][i] != '.' && !columns.add(board[j][i]))
          return false;

        // here, i means cubes, j means index of elements in cube
        int RowIndex = 3 * (i / 3);
        int ColIndex = 3 * (i % 3);
        // using i to locate the "left,top" point (start point) of a cube;
        if (board[RowIndex + j / 3][ColIndex + j % 3] != '.'
            && !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
          return false;
      }
    }
    return true;
  }
}
