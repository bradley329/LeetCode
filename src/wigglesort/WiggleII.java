package wigglesort;

import java.util.Arrays;

//
public class WiggleII {
	public void wiggleSort(int[] nums) {
        int[] temp;
        temp = nums.clone();
        Arrays.sort(temp);
        int n = nums.length;
        int left = (n+1)/2; int right = n;
        for (int i = 0; i < nums.length; i++) {
			nums[i] = ((i & 1) != 0) ? temp[--right] : temp[--left];
		}
    }
}
