package SummaryRanges_228;

import java.util.ArrayList;
import java.util.List;

public class LeetSolution {
  public List<String> summaryRanges(int[] nums) {
    List<String> res = new ArrayList<>();
    if (nums.length == 1) {
      res.add(nums[0] + "");// +"" will automatically invoke toString();
      return res;
    }
    int bt = 0;
    for (int i = 0; i < nums.length; i++) {
      bt = i;
      while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) {
        i++;
      }
      if (bt != i) {
        res.add(nums[bt] + "->" + nums[i]);
      } else {
        res.add(nums[bt] + "");
      }
    }
    return res;
  }
}
