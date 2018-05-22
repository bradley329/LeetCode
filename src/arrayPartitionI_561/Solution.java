package arrayPartitionI_561;

import java.util.Arrays;

public class Solution {
	public int arrayPairSum(int[] nums) {
        int n = nums.length/2;
        if (n == 1) return nums[0] < nums[1] ? nums[0] : nums[1];
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i += 2) {
        	sum += nums[i];
        }
        return sum;
    }
}
