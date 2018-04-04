package CourseraOA;

import java.util.Arrays;

public class ThreeSumSmaller {
	long threeSumSmaller(int[] nums, long target) {
        if (nums.length < 3) return 0;
        long res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
            	long sum = (long) nums[i] + (long) nums[left] + (long) nums[right];
                if (sum <= target) {
                    res += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
