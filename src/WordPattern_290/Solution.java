package WordPattern_290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// note that if a -> dog then there should not be another b -> dog!!!
// so we have to use two maps!!!
// actually for the wordToChar map, using a set is enough!
public class Solution {
	public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
			return false;
		}
        String[] words = str.split(" ");
        char[] chArr = pattern.toCharArray();
        if (pattern.length() != words.length) {
			return false;
		}
        Map<Character, String> charToWord = new HashMap<>();
//        Map<String, Character> wordToChar = new HashMap<>();
        Set<String> wordToChar = new HashSet<>();
        for (int i = 0; i < chArr.length; i++) {
			String word = words[i];
			char character = chArr[i];
			if (charToWord.containsKey(character)) {
				if (!charToWord.get(character).equals(word) ) {
					return false;
				}
			} else if (wordToChar.contains(word)) {
				return false;
			} else {
				charToWord.put(character, word);
				wordToChar.add(word);
			}
		}
        return true;
    }
}
