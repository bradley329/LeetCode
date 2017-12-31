package PowerofTwo_231;

// could have multiple solutions using bit manipulation
// https://leetcode.com/problems/power-of-two/discuss/63966
public class Solution {
	public boolean isPowerOfTwo(int n) {
	    return n>0 && ((n-1)&n)==0;
	}
	
	public boolean isPowerOfTwoI(int n) {
		if(n==0) return false;
		while(n%2==0) n/=2;
		return (n==1);
	}
	
	public boolean isPowerOfTwoII(int n) {
		return n>0 && (n==1 || (n%2==0 && isPowerOfTwo(n/2)));
	}
	/*Because the range of an integer = -2147483648 (-2^31) ~ 2147483647 (2^31-1), the max possible power of two = 2^30 = 1073741824.

			(1) If n is the power of two, let n = 2^k, where k is an integer.

			We have 2^30 = (2^k) * 2^(30-k), which means (2^30 % 2^k) == 0.

			(2) If n is not the power of two, let n = j*(2^k), where k is an integer and j is an odd number.

			We have (2^30 % j*(2^k)) == (2^(30-k) % j) != 0.*/
	public boolean isPowerOfTwoIII(int n) {
		return n>0 && (1073741824 % n == 0);
	}
}
