package longestPalindromicSubstring_5;

public class Solution {
	//this problem should be dealt from the pivot of the palindrome rather than from sides;
    private int lo, maxLen;

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int pivot = 0; pivot < len-1; pivot++) {
	     	extendPalindrome(s, pivot, pivot);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, pivot, pivot + 1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
}
