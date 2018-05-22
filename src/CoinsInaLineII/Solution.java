package CoinsInaLineII;

// http://www.lintcode.com/en/problem/coins-in-a-line-ii/
// dp array stores the !!!diff!!! of values between this person and the other person!
public class Solution {
  public boolean firstWillWin(int[] values) {
    // write your code here
    if (values.length == 0) {
      return false;
    }
    if (values.length == 1) {
      return values[0] > 0;
    }
    int len = values.length;
    int dp[] = new int[len + 1];
    dp[1] = values[len - 1];
    for (int i = 2; i <= len; i++) {
      dp[i] =
          Math.max(values[len - i] - dp[i - 1], values[len - i] + values[len - i + 1] - dp[i - 2]);
    }
    return dp[len] > 0;
  }
}
