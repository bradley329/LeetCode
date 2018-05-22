package subarraysum_2;

import java.util.ArrayList;
import java.util.HashMap;

//ģ��1
//����˼·���� ��û���������������㣬����������Ƚ�general
public class Solution {
	public int subarraySumII(int[] A, int start, int end) {
        // write your code here
		int n = A.length;
		if (n == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		//�����±� �Ǹ���
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
