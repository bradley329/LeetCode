package PaintFence_276;

// i think indeed it is a DP problem
public class Solution {
	int numWays(int n, int k) {
        if (n == 0) return 0;
        int same = 0, diff = k;
        for (int i = 2; i <= n; ++i) {
            int t = diff;
            diff = (same + diff) * (k - 1);
            same = t;
        }
        return same + diff;
    }
	
	// DP style:
	int numWaysDP(int n, int k) {
        if (n == 0) return 0;
        int[] dp = new int[2];
        dp[1 % 2] = k; 
        int diff = k;
        for (int i = 2; i <= n; ++i) {
            int same = diff;
            diff = dp[(i - 1) % 2] * (k - 1);
            dp[(i % 2)] = diff + same;
        }
        return dp[(n % 2)];
    }
}
