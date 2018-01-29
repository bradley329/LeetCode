package PaintHouse_256;

// similar to house robber
// but now we have 3 colors rather than just rober or not
// so we need to use a n*3 matrix as the dp matrix
// dp[i][j] = dp[i][j] + min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3])；
public class Solution {
	int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length != 3) return 0;
        // note we could set dp directly with cost in the initial state
        int[][] dp = costs;
        int n = dp.length;
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 0; j < 3; ++j) {
                dp[i][j] += Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }
        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }
}
