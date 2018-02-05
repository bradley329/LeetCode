package NextPermutation_31;


//from right to left, search for the first index, which has num[index] < num[index+1];
//swap it with the first num in its right, and then swap the whole right part.
public class Solution {
 public void nextPermutation(int[] nums) {
     if (nums == null || nums.length <= 1) {
			return;
		}
     if (nums.length == 2) {
     	swap(nums, 0, 1);
         return;
		}
     int rightEnd = nums.length - 1; 
     int firstSmallerIdx = -1;
     int rightStart = 0; 
     // find the first num which is smaller that its right neighbor
     for (int i = rightEnd; i > 0; i--) {
			if (nums[i-1] < nums[i]) {
				rightStart = i;
				firstSmallerIdx = i-1;
				break;
			}
		}
     
     if (firstSmallerIdx == -1) {
			// descending order, should reverse to the ascending order
     	for (int i = 0; i < nums.length/2; i++) {
				swap(nums, i, nums.length-1 - i);
			}
     	
		} else {
			int firstSmallerNum = nums[firstSmallerIdx];
			int firstLargerIdx = -1;
			// search the first num in the right which is larger than firstSmallerNum
			for (int i = rightEnd; i >= rightStart; i--) {
				if (nums[i] > firstSmallerNum) {
					firstLargerIdx = i;
					break;
				}
			}
			// swap the firstSmallerNum and firstLargerNum
			swap(nums, firstSmallerIdx, firstLargerIdx);
			// swap the whole right part
			while (rightEnd > rightStart) {
				System.out.println(rightEnd);
				System.out.println(rightStart);
				swap(nums, rightEnd, rightStart);
				rightStart++;
				rightEnd--;
			}
		}
 }
 
 private void swap(int[] nums, int i, int j) {
 	int tp = nums[i];
 	nums[i] = nums[j];
 	nums[j] = tp;
 }
}
