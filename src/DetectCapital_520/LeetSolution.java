package DetectCapital_520;

public class LeetSolution {
    public boolean detectCapitalUse(String word) {
        // we make sure that word only have letters!
        if (word == null || word.length() == 0) return false;
        int len = word.length();
        if (len == 1) return true;
        int countCap = 0;
        for (int i = 0; i < len; i++) {
            char cur = word.charAt(i);
            if (cur >= 'A' && cur <= 'Z') countCap++;
        }
        if (countCap != 0 && countCap != len) {
            char firstLetter = word.charAt(0);
            if (!(countCap == 1 && firstLetter>= 'A' && firstLetter <= 'Z')) return false;
        }
        return true;
    }
}
