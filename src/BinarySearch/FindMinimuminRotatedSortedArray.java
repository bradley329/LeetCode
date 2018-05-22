package BinarySearch;

//Given [4, 5, 6, 7, 0, 1, 2] return 0;
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
    	if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        int target = nums[nums.length - 1];
        int mid = start + (end - start) / 2;
        // find the first element <= target
        while (start < end) {
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid+1;
            }
            mid = start + (end - start) / 2;
        }
        return nums[mid];
    }
}
