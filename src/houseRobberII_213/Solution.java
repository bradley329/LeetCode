package houseRobberII_213;

// if arranged in circle, the if index 0 is picked then length-1 can not be picked
// so: 
class Solution {
    public int rob(int[] nums) {
    	if (nums == null || nums.length == 0) {
			return 0;
		}
        int len = nums.length;
        if (len == 1) {
			return nums[0];
		}
        if (len == 2) {
			return Math.max(nums[0], nums[1]);
		}
        return Math.max(rob1(nums, 0, len -2), rob1(nums, 1, len-1));
    }
    
    private int rob1(int[] nums, int st, int end) {
    	int []dp = new int[2];
        if(st == end) 
            return nums[end];
        if(st+1 == end)
            return Math.max(nums[st], nums[end]);
        dp[st%2] = nums[st];
        dp[(st+1)%2] = Math.max(nums[st], nums[st+1]);
        
        for(int i = st+2; i <= end; i++) {
            dp[i%2] = Math.max(dp[(i-1)%2], dp[(i-2)%2] + nums[i]);
            
        }
        return dp[end%2];
    }
}
