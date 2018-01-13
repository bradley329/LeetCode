package RelativeRanks_506;

import java.util.*;

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
			return null;
		}
        int len = nums.length;
    	String[] res = new String[len];
    	Map<Integer, Integer> indexMap = new HashMap<>();
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    	for (int i = 0; i < len; i++) {
    		int val = nums[i];
    		// since values are unique, so don't have to check if exist
			indexMap.put(val, i);
			pq.add(val);
		}
    	int rank = 0;
    	int index = 0;
    	int score = 0;
    	while (!pq.isEmpty()) {
			score = pq.poll();
			rank++;
			switch (rank) {
			case 1:
				index = indexMap.get(score);
				res[index] = "Gold Medal";
				break;
			case 2:
				index = indexMap.get(score);
				res[index] = "Silver Medal";
				break;
			case 3:
				index = indexMap.get(score);
				res[index] = "Bronze Medal";
				break;
			default:
				index = indexMap.get(score);
				res[index] = Integer.toString(rank);
				break;
			}
		}
    	return res;
    }
}
