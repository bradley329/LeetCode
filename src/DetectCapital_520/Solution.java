package DetectCapital_520;
/*We define the usage of capitals in a word to be right when one of the following cases holds:

        All letters in this word are capitals, like "USA".
        All letters in this word are not capitals, like "leetcode".
        Only the first letter in this word is capital if it has more than one letter, like "Google".
        Otherwise, we define that this word doesn't use capitals in a right way.*/
public class Solution {
    public boolean detectCapitalUse(String word) {
        // we make sure that word only have letters!
        if (word == null || word.length() == 0) return false;
        int len = word.length();
        if (len == 1) return true;
        char firstLetter = word.charAt(0);
        if (firstLetter >= 'A' && firstLetter <= 'Z') {
            char secondLetter = word.charAt(1);
            if (secondLetter>= 'A' && secondLetter <= 'Z') {
                // all the other letters should be capital!
                for (int i = 2; i < len; i++) {
                    char cur = word.charAt(i);
                    if (cur >= 'a' && cur <= 'z') return false;
                }
                return true;
            } else {
                // all the other letters should not be capital!
                for (int i = 2; i < len; i++) {
                    char cur = word.charAt(i);
                    if (cur >= 'A' && cur <= 'Z') return false;
                }
                return true;
            }
        } else {
            // all the other letters should not be capital!
            for (int i = 1; i < len; i++) {
                char cur = word.charAt(i);
                if (cur >= 'A' && cur <= 'Z') return false;
            }
            return true;
        }
    }
}
