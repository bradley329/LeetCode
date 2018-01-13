package MaximumProductofThreeNumbers;

import java.util.Arrays;

// dont have to dp
public class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
			return 0;
		}
        Arrays.sort(nums);
        int low = nums[0];
        int high = nums[nums.length-1];
        if (high < 0) {
			return high * nums[nums.length-2] * nums[nums.length-3];
		} else if (low > 0) {
			return high * nums[nums.length-2] * nums[nums.length-3];
		} else {
			return Math.max(low * nums[1] * high, high * nums[nums.length-2] * nums[nums.length-3]);
		}
    }
}
