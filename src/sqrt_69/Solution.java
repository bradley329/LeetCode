package sqrt_69;

public class Solution {
	public int mySqrt(int x) {
		int start = 1; 
		int end = x;
		while (start + 1 < end) {
			int mid = start + (end - start)/2;//һ��Ҫ����Ҫ��Խ�磡
			if ((long) mid * mid <= x) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if ((long) end * end <= x) {
			return end;
		} else {
			return start;
		}
	}
}
