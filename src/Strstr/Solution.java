package Strstr;

public class Solution {
	public int strStr(String haystack, String needle) {
		int h = haystack.length();
		int n = needle.length();
		for (int st = 0; st <= h-n; st++) {
			for (int off = 0; ; off++) {
				if (off == n) {
					return st;
				}
				if (haystack.charAt(st + off) != needle.charAt(off)) {
					break;
				}
			}
		}
		return -1;
	}
}
