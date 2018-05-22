package twosum5;

import java.util.Arrays;
//两边往中间夹逼
public class LeetSolution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 2)
            return 0;

        Arrays.sort(nums);
        int cnt = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int v = nums[left] + nums[right];
            if (v > target) {
                right --;
            } else {
                cnt += right - left;
                left ++;
            }
        }
        return cnt;
    }
}