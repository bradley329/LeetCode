package BinaryNumberwithAlternatingBits_693;

// bit manipulation
// must know how to convert to binary!
public class Solution {
    public boolean hasAlternatingBitsI(int n) {
        String bits = Integer.toBinaryString(n);
        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    // or manually convert to binary digits:
    public boolean hasAlternatingBitsII(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            int pre = n % 2;
            if (cur == pre) return false;
            cur = pre;
            n /= 2;
        }
        return true;
    }
}
