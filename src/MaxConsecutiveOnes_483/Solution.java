package MaxConsecutiveOnes_483;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        int numConsecutive = 0;
        for (int num : nums) {
            if (num == 1) {
                numConsecutive++;
            } else {
                res = Math.max(res, numConsecutive);
                numConsecutive = 0;
            }
        }
        // note the last round
        res = Math.max(res, numConsecutive);
        return res;
    }
}
