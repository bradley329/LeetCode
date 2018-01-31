package WordLadder_127;

import java.util.*;

public class Solution {
	public int ladderLength(String start, String end, List<String> wordList) {
		// using a set since we have to know if we could continue to go down
		// when for example, abc -> abd
        Set<String> words = new HashSet<>();
        words.addAll(wordList);
        if (!words.remove(end)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        int res = 1, len = start.length();
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            res++;
            // to save iteration times
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            Set<String> next = new HashSet<>();
            for (String s : beginSet) {
                char[] ch = s.toCharArray();
                for (int i = 0; i < len; i++) {
                    char original = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String str = String.valueOf(ch);
                        if (endSet.contains(str)) {
                            return res;
                        }
                        if (words.contains(str)) {
                            next.add(str);
                            // note that in the BFS style Single source shortest path
                            // this remove is very safe!
                            // when we start from this point, we never meet it again
                            // since when me meet it later on, the path must be longer!
                            words.remove(str);
                        }
                    }
                    ch[i] = original;
                }
            }
            beginSet = next;
        }
        return 0;
    }
}
