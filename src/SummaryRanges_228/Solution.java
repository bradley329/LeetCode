package SummaryRanges_228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(nums[0]);
    boolean onlyHasOne = true;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1] + 1) {
        onlyHasOne = false;
        continue;
      } else {
        if (!onlyHasOne) {
          stringBuilder.append("->" + nums[i - 1]);
        }
        result.add(stringBuilder.toString());
        stringBuilder.setLength(0);
        stringBuilder.append(nums[i]);
        onlyHasOne = true;
      }
    }

    if (stringBuilder.length() > 0) {
      if (!onlyHasOne) {
        stringBuilder.append("->" + nums[nums.length - 1]);
      }
      result.add(stringBuilder.toString());
    }
    return result;
  }
}
