package pocketgems;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
	// typical dp solution, dp[i] means the max len of subsequences end with nums[i]
	public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int len = nums.length;
		int[] dp = new int[len];
		int res = 0;
		for (int i = 0; i < len; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}				
			}
			res = Math.max(res, dp[i]);
		}
		return res;
    }
	
	// solution using a increasing array (dont have to use stack here)
	public int longestIncreasingSubsequence1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		
		ArrayList<Integer> minLast = new ArrayList<>();
		minLast.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            // find the first number in minLast >= nums[i]
        	binarySearch(minLast, nums[i]);
        }
        
        return minLast.size();
    }
    
    private void binarySearch(ArrayList<Integer> minLast, int num) {
    	if (num == minLast.get(minLast.size()-1)) {
			return;
		}
    	if (num > minLast.get(minLast.size()-1)) {
			minLast.add(num);
			return;
		}
    	// binary search: find the first number > num
        int start = 0, end = minLast.size() - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (minLast.get(mid) < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (minLast.get(start) >= num) {
        	minLast.set(start, num);
		}
        else minLast.set(end, num);
    }
}
