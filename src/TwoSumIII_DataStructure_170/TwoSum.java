package TwoSumIII_DataStructure_170;

import java.util.*;

public class TwoSum {
	private Map<Integer, Integer> map;
	
	public TwoSum() {
		map = new HashMap<>();
	}
 
	void add(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
	
    boolean find(int target) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	int one = entry.getKey();
        	int cnt = entry.getValue();
            int second = target - entry.getKey();
            if ((second != one && map.containsKey(second)) || (second == one && cnt > 1)) {
                return true;
            }
        }
        return false;
    }
}
