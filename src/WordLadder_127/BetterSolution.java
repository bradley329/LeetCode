package wordLadder_127;

import java.util.*;

public class BetterSolution {
	public int ladderLength(String start, String end, List<String> wordList) {   
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
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            //没用queue存的原因是这里不讲究同一级之间左右的顺序。
            //Set即使是无序的也是没问题的
            Set<String> next = new HashSet<>();
            for (String s : beginSet) {
                char[] ch = s.toCharArray();
                for (int i = 0; i < len; i++) {
                    char real = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String str = String.valueOf(ch);
                        if (endSet.contains(str)) {
                            return res;
                        }
                        if (words.contains(str)) {
                            next.add(str);
                            //这个remove很精明
                            words.remove(str);
                        }
                    }
                    ch[i] = real;
                }
            }
            beginSet = next;
        }
        return 0;
    }
}
