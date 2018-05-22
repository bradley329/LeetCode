package maximumaveragesub_643;
public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        double start = min;
        double end = max;
        while (end - start > 1e-5) {
            double mid = start + (end - start) / 2.0;
            if (find(mid, nums, k)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (find(end, nums, k)) {
            return end;
        }
        return start;  
        //或者直接return start因为精度已经很高了
    }
    
    public boolean find(double mid, int[] nums, int k) {
        double[] temp = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i] - mid;
        }
        double sum = 0;
        double last = 0;
        for (int i = 0; i < k; i++) {
            sum += temp[i];
        }
        if (sum >= 0) {
            return true;
        }
        for (int i = k; i < nums.length; i++) {
            sum += temp[i];
            last += temp[i - k];
            if (last < 0) {
                sum -= last;
                last = 0;
            }
            if (sum >= 0) {
                return true;
            }
        }
        return false;
    }
}