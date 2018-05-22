package reverseWordsII_186;

// no trailing space and there is only one space between words
public class Solution {
	public String reverseWords(String s) {
		int len = s.length();
		char[] chaArr = s.toCharArray();
		int wordSt = 0;
		for (int i = 0; i <= len; i++) {
			// reverse chars in the word
			if (i == len || chaArr[i] == ' ') {
				reverse(chaArr, wordSt, i-1);
				wordSt = i + 1;
			}
		}
		// reverse the whole string
		reverse(chaArr, 0, len-1);
		return String.valueOf(chaArr);
	}

	private void reverse(char[] chaArr, int wordSt, int wordEnd) {
		while (wordSt < wordEnd) {
			char t = chaArr[wordSt];
			chaArr[wordSt] = chaArr[wordEnd];
			chaArr[wordEnd] = t;
            ++wordSt; 
            --wordEnd;
		}
	}
}
