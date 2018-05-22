package reverseWordsinaStringII_541;

public class Solution {
	public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
			return "";
		}
        char[] chArr = s.toCharArray();
        int n = chArr.length;
        if (n <= k) {
        	reverseStr(chArr, 0, n-1);
        	return String.valueOf(chArr);
		}
        for (int i = 0; i < n; i += 2*k) {
        	reverseStr(chArr, i, Math.min(i+k-1, n-1));
        }
        return String.valueOf(chArr);
    }
	
	private void reverseStr(char[] chArr, int st, int end) {
		int i = st, j = end;
		for (; i < j; i++, j--) {
			char tp = chArr[j];
			chArr[j] = chArr[i];
			chArr[i] = tp;
		}
	}
}
