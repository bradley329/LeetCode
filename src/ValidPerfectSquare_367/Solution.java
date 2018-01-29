package ValidPerfectSquare_367;

// simple Binary Search solution
public class Solution {
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
			return true;
		}
        int st = 2;
        int end = num / 2;
        while (st < end) {
			int mid = st + (end - st)/2;
			System.out.println(mid);
			// note that if remove the (long) before mid, even if we have 
			// (long) mid * mid, it is still based on the incorrect int result
			long tp = (long) mid * (long) mid;
			System.out.println("tp" +tp);
			if (tp < num) {
				st = mid + 1;
			} else if (tp > num) {
				end = mid - 1;
			} else {
				return true;
			}
		}
        System.out.println(st);
        if (st * st == num) {
			return true;
		} else {
			return false;
		}
    }
    
    public static void main(String[] args) {
		int num = 808201;
		System.out.print(isPerfectSquare(num));
	}
}
