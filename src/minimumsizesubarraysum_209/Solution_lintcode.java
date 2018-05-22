package minimumsizesubarraysum_209;

public class Solution_lintcode {
	public int minimumSize(int[] nums, int s) {
        // write your code here
        int j = 0, i = 0;
        int sum =0;
        int ans = Integer.MAX_VALUE;
        for(i = 0; i < nums.length; i++) {
            while(j < nums.length && sum < s) {
                sum += nums[j];
                j ++;
                // j points to the next end;
            }
            if(sum >=s) {
                ans = Math.min(ans, j - i); // so there is no +1;
            }
            sum -= nums[i];
        }
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        return ans;
    }
}
