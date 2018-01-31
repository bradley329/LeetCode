package AdditiveNumber_306;

public class Solution {
    public boolean isAdditiveNumber(String num) {
    	int n = num.length();
        if (num.length() < 3) {
			return false;
		}
        char[] chArr = num.toCharArray();
        // classical two pointers for solving Three parts problems
        mainloop:
        for (int i = 1; i <= n/2; i++) {
			for (int j = i + 1; j - i <= n/2; j++) {
				String s1 = num.substring(0, i);
				String s2 = num.substring(i, j);
				// s3 can not be decided since it should equals to the sum of s1 and s2
				// corner case: leading zeroes
				if (s1.length() > 1 && s1.charAt(0) == '0') {
					break mainloop;
				}
				if (s2.length() > 1 && s2.charAt(0) == '0') {
					continue mainloop;
				}
				
				int s3StartIdx = j;
				long d1 = Long.parseLong(s1);
				long d2 = Long.parseLong(s2);
				long d3 = d1 + d2;
				String s3 = String.valueOf(d3);
				int s3EndIdx = s3StartIdx + s3.length();
				while (s3EndIdx < n) {
					if (s3.equals(num.substring(s3StartIdx, s3EndIdx))) {
						//continue
						d1 = d2;
						d2 = d3;
						d3 = d1 + d2;
						s3 = String.valueOf(d3);
						s3StartIdx = s3EndIdx;
						s3EndIdx = s3StartIdx + s3.length();
					} else {
						break;
					}
				}
				if (s3EndIdx == n) {
					if (s3.equals(num.substring(s3StartIdx, s3EndIdx))) {
						return true;
					}
				}
			}
		}
        return false;
    }
}
