package MajorityElement_229;

import java.util.ArrayList;
import java.util.List;

// 众数投票法
public class Solution {
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    int num1 = nums[0];
    int num2 = nums[0];
    int cnt1 = 0;
    int cnt2 = 0;
    int len = nums.length;
    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      if (num1 == cur) {
        cnt1++;
      } else if (num2 == cur) {
        cnt2++;
      } else if (cnt1 == 0) {
        num1 = cur;
        cnt1++;
      } else if (cnt2 == 0) {
        num2 = cur;
        cnt2++;
      } else {
        cnt1--;
        cnt2--;
      }
    }
    cnt1 = 0;
    cnt2 = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] == num1)
        cnt1++;
      else if (nums[i] == num2)
        cnt2++;
    }
    if (cnt1 > len / 3)
      res.add(num1);
    if (cnt2 > len / 3)
      res.add(num2);
    return res;
  }
}
