package LargestNumberGreaterThanTwiceofOthers_747;

public class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int len = nums.length;
        int idx = 0;
        int max = nums[0];
        int subMax = -1;
        for (int i = 1; i < len; i++) {
        	if (nums[i] > max) {
				subMax = max;
				max = nums[i];
				idx = i;
			} else if (nums[i] > subMax) {
				subMax = nums[i];
			}
		}
        return max >= (subMax * 2) ? idx : -1;
    }
}
