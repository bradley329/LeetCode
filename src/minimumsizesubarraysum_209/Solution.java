package minimumsizesubarraysum_209;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	if(nums==null||nums.length==0) return 0;
    	int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
    	boolean found = false;
        while (end < nums.length) {
            while (end < nums.length && sum < s) sum += nums[end++];
            if (sum < s) break;//never found one eligible
            // since we are finding the min length, so it could be a while loop instead of a single if;
            while (start < end && sum >= s) sum -= nums[start++];
            if (end - start + 1 < minLen) {
                minLen = end - start + 1;
                found = true;
            }
        }
        return found ? minLen : 0;
    }
}
