package DrawBridgeOA;

import java.util.Arrays;
import java.util.Comparator;

public class SortNumsByOnes {
	public static int countOnes(int num) {
		int cnt = 0;
		while (num > 0) {
			if ((num & 1) == 1) {
				cnt++;
			}
			num = num >> 1;
		}
		return cnt;
	}

	public static int[] helper(int[] nums) {
		Comparator<Integer> myComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if (a.equals(b)) {
					return 0;
				} else if (countOnes(a) - countOnes(b) > 0) {
					return 1;
				} else if (countOnes(a) - countOnes(b) < 0) {
					return -1;
				} else {
					return a.compareTo(b);
				}
			}
		};
		int[] res = Arrays.stream(nums).
				boxed().
			    sorted(myComparator). 
			    mapToInt(i -> i).
			    toArray();
		return res;
	}
	
	public static void main(String[] args) {
		int[] test = {4,6,2,1,7,5,3};
		int[] res = helper(test);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
	}
}
