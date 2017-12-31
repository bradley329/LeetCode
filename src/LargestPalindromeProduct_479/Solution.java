package LargestPalindromeProduct_479;

// first, we have to prove that the res must have "even" number of digits
public class Solution {
	public int largestPalindrome(int n) {
		if (n == 1) return 9;
        int max = (int) Math.pow(10, n) - 1;
        for (int v = max - 1; v > max / 10; v--) {
            long u = Long.valueOf(v + new StringBuilder().append(v).reverse().toString());
            // x is the larger one in the two numbers
            for (long x = max; x * x >= u; x--)
                if (u % x == 0)
                    return (int) (u % 1337);
        }
        return 0;
    }
}
