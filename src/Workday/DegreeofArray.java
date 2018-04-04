package Workday;

import java.util.HashMap;
import java.util.Map;

public class DegreeofArray {
	static int degreeOfArray(int[] arr) {
        // Write your code here.
		int degree = 0;
		int len = arr.length;
		int min = len;
		Map<Integer, Integer> countMap = new HashMap<>();
		Map<Integer, Integer[]> indexMap = new HashMap<>();
		for (int i = 0; i < len; i++) {
			int cnt = countMap.getOrDefault(arr[i], 0) + 1;
			countMap.put(arr[i], cnt);
			degree = Math.max(degree, cnt);
			Integer[] indices;
			if (indexMap.containsKey(arr[i])) {
				indices = indexMap.get(arr[i]);
				indices[1] = Integer.valueOf(i);
			} else {
				indices = new Integer[2];
                indices[0] = Integer.valueOf(i); 
				indices[1] = Integer.valueOf(i);
				indexMap.put(arr[i], indices);
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
