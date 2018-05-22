package LongestIncreasingContinuousSubsequence;
//http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence/
public class Solution {
	public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
		if (A.length == 0) {
			return 0;
		}
		int incLen = 1;
		int incMax = 1;
		int decLen = 1;
		int decMax = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i-1]) {
				incLen++;
				incMax = Math.max(incLen, incMax);				
				decLen = 1;
			} else if (A[i] < A[i-1]) {
				decLen++;
				decMax = Math.max(decLen, decMax);
				incLen = 1;
			} else {
				decLen = 1;
				incLen = 1;
			}
		}
		return Math.max(incMax, decMax);
    }
}
