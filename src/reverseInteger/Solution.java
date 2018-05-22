package reverseInteger;

public class Solution {
	public int reverse(int x) {
        int result = 0, iter = x;
        if (x < 0) iter = -iter;
        while(iter > 0) {
            if (result > Integer.MAX_VALUE / 10) return 0;
            result = result * 10 + iter % 10;
            iter = iter / 10;
        }
        if (x < 0) result= -result;
        return result;
    }
}
