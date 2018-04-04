package CourseraOA;

public class SubarrayProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 0)
			return 0;
		if (nums == null || nums.length == 0)
			return 0;

		long product = 1;
		int left = 0;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			product *= num;
			while (product >= k && left <= i) {
				product /= nums[left];
		        left += 1;
			}
		    result += i - left + 1;    
		}
		           
		return result;
	}
}
