package SingleElementinSortedArray_540;

public class Solution {
  public int singleNonDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length % 2 == 0) {
      return -1;
    }

    // length is at least 3
    int st = 0;
    int end = nums.length - 1;
    // length is at least 3
    while (st + 1 < end) {
      int mid = st + (end - st) / 2;
      int numMid = nums[mid];
      if (numMid > nums[mid - 1] && numMid < nums[mid + 1]) {
        return nums[mid];
      }
      if (mid % 2 == 0) {
        if (numMid != nums[mid + 1]) {
          end = mid;
        } else {
          st = mid;
        }
      } else {
        if (numMid != nums[mid - 1]) {
          end = mid;
        } else {
          st = mid;
        }
      }
    }
    if (st % 2 == 0) {
      if (nums[st] != nums[st + 1]) {
        return nums[st];
      } else {
        return nums[end];
      }
    } else {
      if (nums[st] != nums[st - 1]) {
        return nums[st];
      } else {
        return nums[end];
      }
    }
  }
}
