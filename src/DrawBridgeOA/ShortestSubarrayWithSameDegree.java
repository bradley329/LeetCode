package DrawBridgeOA;

import java.util.*;

public class ShortestSubarrayWithSameDegree {
	
	public static int find(int[] nums) {
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
				indexMap.put(nums[i], indices);
				indices[0] = Integer.valueOf(i); 
				indices[1] = Integer.valueOf(i);
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
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,3,3,2,2};
		System.out.print(find(input));
	}
}
