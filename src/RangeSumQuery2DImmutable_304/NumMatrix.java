package RangeSumQuery2DImmutable_304;

public class NumMatrix {
  private int[][] sumDp;

  private int m;
  private int n;

  public NumMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return;
    }
    m = matrix.length;
    n = matrix[0].length;
    sumDp = new int[m + 1][n + 1]; // index start from 1;
    init(matrix);
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sumDp[row2 + 1][col2 + 1] - sumDp[row1][col2 + 1] - sumDp[row2 + 1][col1]
        + sumDp[row1][col1];
  }

  private void init(int[][] matrix) {
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        sumDp[i][j] =
            sumDp[i][j - 1] + sumDp[i - 1][j] - sumDp[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }
  }
}
