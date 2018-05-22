package findMininRotatedSortedArr_153;

public class Solution {
	public int findMin(int[] nums) {
        if(nums.length <= 1) return nums[0];
        int bottom = 0; int top = nums.length-1;
        int mid = (bottom + top)/2; 
        // start + 1 < end
        while (mid != bottom) {
        	if (nums[mid]<nums[top]) {
        		top = mid;
        	} else {
        		bottom = mid;
        	}
        	mid = (bottom + top) / 2;
        }
        return Math.min(nums[bottom],nums[top]);
    }
}
