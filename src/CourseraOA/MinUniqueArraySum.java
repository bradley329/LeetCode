package CourseraOA;

import java.util.Arrays;

public class MinUniqueArraySum {
	public int MinSum(int[] arr) {
		Arrays.sort(arr);
		int pre = arr[0];
		int arrSum = pre;
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			if (pre >= cur) {
				cur = pre + 1;
			}
			pre = cur;
			arrSum += pre;							
		}					
		return arrSum;
	}
}
