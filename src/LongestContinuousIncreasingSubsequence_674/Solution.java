package LongestContinuousIncreasingSubsequence_674;

public class Solution {
	public int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0) {
            return 0;
        }
		int n = nums.length;
		// from left to right
        int length = 1; // just A[0] itself
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                length++;
                res = Math.max(res, length);
            } else {
                length = 1;
            }
        }
        return res;
    }
}
