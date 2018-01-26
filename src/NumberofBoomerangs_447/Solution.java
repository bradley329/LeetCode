package NumberofBoomerangs_447;

import java.util.*;

// this solution is very clear, but TLE
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
			return -1;
		}
        // at most 500, so we may only want use an array of maps
        // rather than map of maps
        // Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        // Map<Integer, Integer>[] maps = new Map<Integer, Integer>()[points.length];
        List<Map<Integer, Integer>> maps = new ArrayList<>(points.length);
        for (int i = 0; i < points.length; i++) {
			maps.add(new HashMap<Integer, Integer>());
		}
        
        for (int i = 0; i < points.length-1; i++) {
			int x = points[i][0];
			int y = points[i][1];
			for (int j = i+1; j < points.length; j++) {
				int another_x = points[j][0];
				int another_y = points[j][1];
				// the distance could not over flow int
				int deltaX = x - another_x;
				int deltaY = y - another_y;
				int distance = deltaX * deltaX + deltaY * deltaY;
				Map<Integer, Integer> countMap = maps.get(i);
				if (!countMap.containsKey(distance)) {
					countMap.put(distance, 1);
				} else {
					countMap.put(distance, countMap.get(distance) + 1);
				}
				countMap = maps.get(j);
				if (!countMap.containsKey(distance)) {
					countMap.put(distance, 1);
				} else {
					countMap.put(distance, countMap.get(distance) + 1);
				}
			}
		}
        int res = 0;
        for (Map<Integer, Integer> countMap : maps) {
			for (int count : countMap.values()) {
				if (count > 1) {
					// if count = 4, then 3+2+1
					res += count * (count - 1) / 2;
				}
			}
		}
        return res;
    }
}
