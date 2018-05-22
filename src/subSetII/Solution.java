package subSetII;

import java.util.*;

//第一想法是sort还是可以想到的
public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tp = new ArrayList<>();
		Arrays.sort(nums);
		DFShelper(tp, res, 0, nums);
        return res;
    }
	
	private void DFShelper(List<Integer> tp, List<List<Integer>> res, int pos, int[] nums) {
		res.add(new ArrayList<>(tp));
		for (int i = pos; i < nums.length; i++) {
			if (i != pos && nums[i-1] == nums[i]) 
				continue;
			tp.add(nums[i]);
			DFShelper(tp, res, i+1, nums);
			tp.remove(tp.size()-1);
		}
	}
}
