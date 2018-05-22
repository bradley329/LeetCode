package pocketgems;

//this is when two rods have to be adjacent!
public class CombineRod_DP {
	public static int stoneGame(int[] A) {
        // write your code here
		if (A.length <= 1) {
			return 0;
		}
		int n = A.length;
		int[][] dp = new int[n][n];
		int[] sumArr = new int[A.length+1];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 0; // only have one element, can't combine, zero cost 
			sumArr[i+1] = sumArr[i] + A[i];
		}
		for (int len = 2; len <= n; len++) {
			for (int st = 0; st <= n - len; st++) {
				dp[st][st+len-1] = Integer.MAX_VALUE;
				int sum = 0;
				sum = sumArr[st+len] - sumArr[st]; 
								
				for (int k = st; k < st + len - 1; k++) {
					dp[st][st+len-1] = Math.min(dp[st][st+len-1], sum + dp[st][k] + dp[k+1][st+len-1]);	
				} 
			}
		}
		return dp[0][n-1];
    }
	
	public static void main(String[] args) {
		System.out.print(stoneGame(new int[]{4, 4, 5, 9}));
	}
}
