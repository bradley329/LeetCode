package SearchInsertPosition_35;

// very basic binary search
public class Solution {
	public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
			return 0;
		}
        int st = 0;
        int end = nums.length - 1;
        while (st < end) {
			int mid = st + (end - st) / 2;
			int numMid = nums[mid];
			if (numMid == target) {
				return mid;
			} else if (numMid < target) {
				st = mid + 1;
			} else {
				end = mid - 1;
			}
		}
        if (nums[st] == target) {
			return st;
		} else if (nums[st] < target) {
			return st+1;
		} else {
			return st;
		}
    }
}
