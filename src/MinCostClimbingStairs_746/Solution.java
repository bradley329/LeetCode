package MinCostClimbingStairs_746;

//note: 很奇妙的是他居然是可以跨过最后一个的。。。
public class Solution {
	// all cost[i] are non-negative
    public int minCostClimbingStairs(int[] cost) {
    	if (cost == null || cost.length < 2) {
			return -1;
		}
    	// length of cost is at least 2;
    	int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
			dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
		}
        return Math.min(dp[len-1], dp[len-2]);
    }
}
