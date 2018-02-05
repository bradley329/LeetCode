package CourseraOA;

public class ArrayGame {
	public static int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
           	min = Math.min(min, nums[j]);
        }
        for (int j = 0; j < n; j++) {
        	sum = sum +(nums[j]-min);
        }		 
        return sum;
    }
}
