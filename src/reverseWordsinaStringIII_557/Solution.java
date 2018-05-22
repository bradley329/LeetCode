package reverseWordsinaStringIII_557;

public class Solution {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
			return "";
		}
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(reverseStr(sArr[0]));
        for (int i = 1; i < sArr.length; i++) {
			sb.append(" ");
			sb.append(reverseStr(sArr[i]));
		}
        return sb.toString();
    }
	
	private char[] reverseStr(String s) {
		char[] chArr = s.toCharArray();
		int i = 0, j = chArr.length-1;
		for (; i < j; i++, j--) {
			char tp = chArr[j];
			chArr[j] = chArr[i];
			chArr[i] = tp;
		}
		return chArr;
	}
}
