package woodcut;

public class Solution {
	public int woodCut(int[] L, int k) {
        // write your code here
		int max = 0;
		for (int i = 0; i < L.length; i++) {
			max = Math.max(L[i], max);
		}
		int start = 1; 
		int end = max;
		while (start + 1 < end) {
			int mid = start + (end - start)/2;
			if (count(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
		}
		if (count(L, end) >= k) {
            return end;
        }
        if (count(L, start) >= k) {
            return start;
        }
        return 0;
    }
	private int count(int[] L, int length) {
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i] / length;
        }
        return sum;
    }
}
