package VMWareOA;

import java.util.Arrays;

public class FindNumSmaller {
	public static void answer() {
		String ss = " swd,ada. ";
		String[] strings = ss.split("\\s+");
		for (String s: strings) {
			System.out.print(s);
		}
		int[] nums = {1,2,3,4,5};
		int[] maxes = {4,7};
		Arrays.sort(nums);
		int[] res = new int[maxes.length];
		int index = 0;
		for (int max : maxes) {
			res[index] = searchInsert(nums, max);
			index++;
		}
		for (int i : res) {
			System.out.print(i);
		}
	}
	
	public static void main(String[] args) {
		answer();
	}
	
	public static int searchInsert(int[] nums, int target) {
/*        if (nums == null || nums.length == 0) {
			return 0;
		}*/
        int st = 0;
        int end = nums.length - 1;
        while (st < end) {
			int mid = st + (end - st) / 2;
			int numMid = nums[mid];
			if (numMid <= target) {
				st = mid + 1;
			} else {
				end = mid - 1;
			}
		}
        if (nums[st] > target) {
			return st;
		} else {
			return st+1;
		}
    }
}
