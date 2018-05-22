package ThreeSumClosest_16;

import java.util.Arrays;

public class LeetSolution {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
		    return 0;
		}
		int result = Integer.MAX_VALUE;
		int diff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
		    if (i > 0 && nums[i] == nums[i - 1]) {
		        continue;
		    }
		    int left = i + 1;
		    int right = nums.length - 1;
		    while (left < right) {
		        int sum = nums[i] + nums[left] + nums[right];
		        if (sum == target) {
		            return target;
		        } else if (sum < target) {
		            int temp = target - sum;
		            if (temp < diff) {
		                result = sum;
		                diff = temp;
		            }
		            left++;
		        } else {
		            int temp = sum - target;
		            if (temp < diff) {
		                result = sum;
		                diff = temp;
		            }
		            right--;
		        }
		    }
		}
		return result;
	}
}
