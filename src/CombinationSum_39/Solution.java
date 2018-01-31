package CombinationSum_39;

import java.util.*;

// a very typical BackTracking or DFS problem
public class Solution {
	private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        if (target < candidates[0]) {
			return res;
		}
        List<Integer> tp = new ArrayList<>();
        if (target == candidates[0]) {
        	tp.add(candidates[0]);
        	res.add(tp);
			return res;
		}
        BackTrackingHelper(0, candidates, target, tp);
        return res;
    }
    
    private void BackTrackingHelper(int st, int[] candidates, int target, List<Integer> tp) {
    	if (st >= candidates.length || target < 0) {
			return;
		}
    	if (target == 0) {
    		res.add(new ArrayList<>(tp));
			return; 
		}
    	for (int i = st; i < candidates.length; i++) {
    		tp.add(candidates[i]);
    		BackTrackingHelper(i, candidates, target - candidates[i], tp);
    		tp.remove(tp.size()-1);
    	}
     }
}
