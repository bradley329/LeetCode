package MinimumPathSum_64;

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}
        int m = grid.length;
        int n= grid[0].length;
        if (m == 1 && n == 1) {
			return grid[0][0];
		}
        if (m == 1) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += grid[0][i];
			}
			return sum;
		}
        if (n == 1) {
        	int sum = 0;
			for (int i = 0; i < m; i++) {
				sum += grid[i][0];
			}
			return sum;
		}
        
        // n>1 and m>1
        int[][] dp = new int[m][n];
        
        // init dp array
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}
        for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
        
        for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}
        return dp[m-1][n-1];
    }
}
