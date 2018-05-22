package subarraysum_2;

import java.util.ArrayList;
import java.util.HashMap;

//模仿1
//不是思路不对 是没有利用数都大于零，我这个方法比较general
public class Solution {
	public int subarraySumII(int[] A, int start, int end) {
        // write your code here
		int n = A.length;
		if (n == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		//不计下标 记个数
		int res = 0;
		int sum = 0;
		map.put(sum, 1);
		for (int i=0; i<n; i++) {
			sum += A[i];
			for (int st = start; st <= end; st++) {
				if (map.containsKey(sum-st)) {
					res += map.get(sum-st);
				}
			}
			if (map.containsKey(sum)) {
				map.put(sum, map.get(sum)+1);
			} else {
				map.put(sum, 1);
			}
		}
		return res;
    }
}
