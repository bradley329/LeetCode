package pocketgems;

public class MaximumProductSubarray {
	public int maxProduct1(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        
        min[0] = max[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            result = Math.max(result, max[i]);
        }
        
        return result;
    }
	
	public int maxProduct2(int[] nums) {
		// so now we only store the max and min ending at the pre index!
        int max_ending;
        int min_ending;
        
        // pre min and max so intitialize with 1!
        min_ending = max_ending = nums[0];
        int result = max_ending;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
            	max_ending = Math.max(nums[i], max_ending * nums[i]);
            	min_ending = Math.min(nums[i], min_ending * nums[i]);
            } else if (nums[i] < 0) {
            	// dont forget to use temp!!!!
            	int max_tp = max_ending;
            	max_ending = Math.max(nums[i], min_ending * nums[i]);
            	min_ending = Math.min(nums[i], max_tp * nums[i]);
            } else {
				max_ending = 0;
				min_ending = 0;
			}
            
            result = Math.max(result, max_ending);
        }
        return result;
    }
}
