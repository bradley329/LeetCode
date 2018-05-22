package twosum5;

import java.util.Arrays;
//this version will have TLE error
public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
    	Arrays.sort(nums);
    	int limit = nums.length;
    	int count = 0;
    	for (int i = 0; i < limit; i++) {
			for (int j = i+1; j < limit; j++) {
				if (nums[j] <= target - nums[i]) {
					count++;
				}
				else {
					limit = j;
					break;
				}
			}
		}
    	return count;
    }
}
