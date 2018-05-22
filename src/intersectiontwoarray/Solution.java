package intersectiontwoarray;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0 ||nums2.length == 0) {
			return new int[0];
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int num:nums1) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			} else {
				map.put(num, 1);
			}
		}
		for (int num:nums2) {
			if (map.containsKey(num) && map.get(num)>0) {
				list.add(num);
				map.put(num, map.get(num)-1);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
