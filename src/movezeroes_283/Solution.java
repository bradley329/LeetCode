package movezeroes_283;
//given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
public class Solution {
	public void moveZeroes(int[] nums) {
		int len = nums.length;
		int nonzero_index = 0;		
		for(int i=0; i<len; i++) {
			if(nums[i]!=0) {
				int tp = nums[nonzero_index];
				nums[nonzero_index] = nums[i];
				nums[i] = tp;
				nonzero_index++;
			}
		}
	}
}
