package ValidSudoku_36;

import java.util.HashSet;
import java.util.Set;

// �����Ľⷨ���������i��jһ���̶�����Ķ���
// ע�⵽9��9������9��cube
// i��j��ѭ���ڣ����Դ���rowNum, colNum.Ҳ��������ɨcubes
// ֻҪ������ɨ������matrix�����У�
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
