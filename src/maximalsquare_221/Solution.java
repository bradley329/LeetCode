package maximalsquare_221;
//�Ǹ�maximal rectangle���񣬵��Ǿͼ򵥺ܶ� ���ֵ�Ҳ����˶��Ǻͱ߳���
//maximal rectangle �����Ǹ�����ջ�ķ�����
//�����¶���
public class Solution {
	public int maxSquare(int[][] matrix) {
		int res = 0;
		int n = matrix.length;
		int m = 0;
		if (n > 0) {
			m = matrix[0].length;
		} else {
			return 0;
		}
		int dp[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			dp[i][0] = matrix[i][0];
			res = Math.max(dp[i][0], res);
			for (int j = 1; j < m; j++) {
				if (i == 0) {
					dp[i][j] = matrix[i][j];
				} else {
					if(matrix[i][j] > 0) {
                        dp[i][j] = Math.min(dp[i - 1][j],Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    } else {
                        dp[i][j] = 0;
                    }
				}
				res = Math.max(res, dp[i][j]);
			}			
		}
		return res*res;
	}
}
