package ThreeSumClosest_16;

import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		if (n < 3) {
			return Integer.MIN_VALUE;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "->");
		}
		// initial state:
		int min_distance = Integer.MAX_VALUE;
		int res = 0;
		int[] print = new int[3];
		for (int pivot = 0; pivot < n - 2; pivot++) {
    		if (pivot == 0 || pivot > 0 && nums[pivot] != nums[pivot-1]) {
    			int low = pivot+1; int high = n-1;
    			while (low < high) {
        			int one = nums[pivot], two = nums[low], three = nums[high];  
        			int sum = one + two + three;
        			int distance = Math.abs(sum - target);
        			if(distance < min_distance) {
        				min_distance = distance;
                		res = sum;
                		print[0] = pivot;
                		print[1] = low;
                		print[2] = high;
                	   
                	    if (sum < target) {
                    	    while (low < high && two == nums[low+1]) low++;
                	    	low++; // try to get closer to zero
                	    }
            			else {
            				while (low < high && three == nums[high-1]) high--;
            				high--;
            			}
        			} else if (sum < target) {
        				while (low < high && two == nums[low+1]) low++;
            	    	low++; // try to get closer to zero
        			} else {
        				while (low < high && three == nums[high-1]) high--;
        				high--;
        			}
            	}
    		}

    	}
		System.out.println(print[0] + "->" + print[1] + "->" + print[2]);
		return res;
    }
}
