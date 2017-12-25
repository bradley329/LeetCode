package CountBinarySubstrings_696;

public class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        if (s == null || s.length() == 0) return res;
        int len = s.length();
        int preLen = 0; int curLen = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i-1)) curLen++;
            else {
                preLen = curLen;
                curLen = 1;
            }
            if (preLen >= curLen) res++;
        }
        return res;
    }
}
