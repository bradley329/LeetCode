package LongestIncreasingSubsequence_300;

// pac man style dp:
public class Solution {
	public int lengthOfLIS(int[] nums) {
        int len = nums.length;
		int[] dp = new int[len];
		int res = 0;
		for (int i = 0; i < len; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}				
			}
			res = Math.max(res, dp[i]);
		}
		return res;
    }
}
