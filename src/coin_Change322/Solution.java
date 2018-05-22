package coin_Change322;

import java.util.Arrays;

//×¢Òâ£º1+MAX = MIN£¡
public class Solution {
    public static int coinChange(int[] coins, int amount) {
    	if (amount < 0 || coins.length == 0) {
			return -1;
		}
    	int[] dp = new int[amount+1];
    	Arrays.fill(dp, -1);
    	dp[0] = 0;
    	return DPHelper(dp, coins, amount);
    }
    
    private static int DPHelper(int[] dp, int[] coins, int amount) {
    	if (amount < 0) {
			return -1;
		}
    	if (dp[amount] != -1) {
			return dp[amount];
		}

    	for (int i = 0; i < coins.length; i++) {
    		int tp = DPHelper(dp, coins, amount - coins[i]);
    		if (tp != -1) {
    			if (dp[amount] != -1) {
    				dp[amount] = Math.min(dp[amount], 1 + tp);
				} else {
					dp[amount] = 1 + tp;
				}    			
			}			
		}
    	return dp[amount];
    }
    
    public static void main (String[] args) {
    	int[] coins = {2};
    	int amount = 1;
    	Solution.coinChange(coins, amount);
    }
}
