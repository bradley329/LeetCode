package DegreeofanArray_697;

import java.util.*;

public class Solution {
	// very straight forward, not fancy solution
	public int findShortestSubArray(int[] nums) {
        int degree = 0;
		int len = nums.length;
		int min = len;
		Map<Integer, Integer> countMap = new HashMap<>();
		Map<Integer, Integer[]> indexMap = new HashMap<>();
		for (int i = 0; i < len; i++) {
			int cnt = countMap.getOrDefault(nums[i], 0) + 1;
			countMap.put(nums[i], cnt);
			degree = Math.max(degree, cnt);
			Integer[] indices;
			if (indexMap.containsKey(nums[i])) {
				indices = indexMap.get(nums[i]);
				indices[1] = Integer.valueOf(i);
			} else {
				indices = new Integer[2];
                indices[0] = Integer.valueOf(i); 
				indices[1] = Integer.valueOf(i);
				indexMap.put(nums[i], indices);
			}
		}
		
		for (int candidate : countMap.keySet()) {
			if (countMap.get(candidate) == degree) {
				Integer[] indices = indexMap.get(candidate);
				min = Math.min(min, indices[1] - indices[0] + 1);
			}
		}
		return min;
    }
}
