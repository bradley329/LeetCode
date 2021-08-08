package topkfrequentelem_347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// no need to declare Pair class
public class SolutionBetter {
  public int[] topKFrequent(int[] nums, int k) {
    int[] res = new int[k];
    if (nums.length == 0) {
      return res;
    }

    Map<Integer, Integer> num_count = new HashMap<>();
    PriorityQueue<Integer> pq =
        new PriorityQueue<>((n1, n2) -> num_count.get(n1) - num_count.get(n2));

    for (int num : nums) {
      num_count.put(num, num_count.getOrDefault(num, 0) + 1);
    }

    for (int num : num_count.keySet()) {
      pq.offer(num);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    for (int i = k - 1; i >= 0; i--) {
      res[i] = pq.poll();
    }

    return res;
  }
}
