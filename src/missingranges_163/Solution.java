package missingranges_163;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		int expected = lower; //next expected num;
		
		for (int num : nums) {
			if (expected == num) {
				expected++;
				continue;
			}
			if (expected < num) {
				res.add((num - 1 == expected)? Integer.toString(expected) : Integer.toString(expected)+"->"+Integer.toString(num-1));
				expected = num+1;
			}
		}
		//corner case
		if (expected < upper+1) {
			res.add((upper == expected)? Integer.toString(expected) : Integer.toString(expected)+"->"+Integer.toString(upper));			
		}
		return res;
	}
}
