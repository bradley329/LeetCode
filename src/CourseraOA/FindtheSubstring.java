package CourseraOA;

public class FindtheSubstring {
	public int findSubstr(String s, String x) {
		int start = 0;
		int i = 0;
		int j = 0;
		int sLen = s.length();
		int xLen = x.length();
		while (i < sLen && j < xLen) {
			if (s.charAt(i) == x.charAt(j) || x.charAt(j) == '*') {
				i++;
				j++;
			} else {
				start++;
				i = start;
				j = 0;
			}
				
		}	
		if (j < xLen) {
			return -1;
		} else {
			return start;
		}	
	}
}
