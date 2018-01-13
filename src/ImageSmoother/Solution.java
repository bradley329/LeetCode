package ImageSmoother;

public class Solution {
	private final int[] dx = {0, 1, -1};
	private final int[] dy = {0, 1, -1};
	private int m;
	private int n;
	private int[][] res;
    public int[][] imageSmoother(int[][] M) {
    	if (M == null || M.length == 0) {
			return res;
		}
    	m = M.length;
    	n = M[0].length;
        res = new int[m][n];
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				helper(i, j, M);
			}
		}
        return res;
    }

	private void helper(int x, int y, int[][] M) {
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < dx.length; i++) {
			for (int j = 0; j < dy.length; j++) {
				int neighborX = x + dx[i];
				int neighborY = y + dy[j];
				if (neighborX < 0 || neighborX >= m ||
						neighborY < 0 || neighborY >= n) {
					continue;
				} else {
					cnt++;
					sum += M[neighborX][neighborY]; // note should use M here!!!
				}
			}
		}
		res[x][y] = sum / cnt;
	}
}
