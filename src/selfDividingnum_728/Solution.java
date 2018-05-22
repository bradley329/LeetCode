package selfDividingnum_728;

import java.util.*;

public class Solution {
	public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) ans.add(n);
        }
        return ans;
    }
	
	private boolean selfDividing(int num) {
		for (char d : String.valueOf(num).toCharArray()) {
			if (d == '0' || (num) % (d - '0') != 0) return false;
		}
		return true;
	}
}
