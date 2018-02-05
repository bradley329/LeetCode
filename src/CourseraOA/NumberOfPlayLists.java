package CourseraOA;

public class NumberOfPlayLists {
	public static int helper(int n, int k, int l) {
		int res = 1;
		for (int i = 0; i < l; i++) {
			if (i < k) {
				res *= (n-i);
			} else {
				res *= (n-k);
			}
		}
		System.out.print(res);
		return res;
	}
	public static void main(String[] args) {
		helper(4, 2, 7);
	}
}
