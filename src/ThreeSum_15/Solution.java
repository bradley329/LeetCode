package ThreeSum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public static List<List<Integer>> threeSum(int[] nums) {
    int len = nums.length;
    List<List<Integer>> ll = new ArrayList<List<Integer>>();
    if (len < 3)
      return ll;

    Arrays.sort(nums);
    int sum = 0;

    for (int pivot = 0; pivot < len - 2; pivot++) {
      if (pivot == 0 || pivot > 0 && nums[pivot] != nums[pivot - 1]) {
        int low = pivot + 1;
        int high = len - 1;
        while (low < high) {
          int one = nums[pivot], two = nums[low], three = nums[high];
          sum = one + two + three;
          if (sum == 0) {
            ll.add(Arrays.asList(one, two, three));
            // the most fancy part comes as follows
            // it is true since nums[] is already sorted
            while (low < high && two == nums[low + 1])
              low++;
            while (low < high && three == nums[high - 1])
              high--;
            low++;
            high--;
          } else if (sum < 0) {
            while (low < high && two == nums[low + 1])
              low++;
            low++;
          } else {
            while (low < high && three == nums[high - 1])
              high--;
            high--;
          }
        }
      }
    }
    return ll;
  }
}
