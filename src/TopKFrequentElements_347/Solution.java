package TopKFrequentElements_347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    List<List<Integer>> buckets = new ArrayList<List<Integer>>();
    for (int i = 0; i < nums.length; i++) {
      buckets.add(new ArrayList<>());
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      // note: entry.getValue() - 1
      buckets.get(entry.getValue() - 1).add(entry.getKey());
    }

    for (int i = buckets.size() - 1; i >= 0; i--) {
      for (int j = 0; j < buckets.get(i).size(); j++) {
        res.add(buckets.get(i).get(j));
      }
    }
    return res;
  }
}
