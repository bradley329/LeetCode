package FindAllAnagramsinaString_438;

import java.util.*;

public class Solution {
	public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new ArrayList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size(); // how many different characters
        
        int begin = 0, end = 0;
        
//        int head = 0;
//        int len = Integer.MAX_VALUE;
        
        // sliding window start when begin is at 0 and end - begin = window size  
        // 这个方法的sliding window不是优先固定sliding window的size 去检测每个sliding window符不符合
        // 而是优先满足必要条件即所有要求的character都是有的，再在大的这个substring里面逐渐减少size（begin++）。
        while (end < s.length()) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            
            while (counter == 0) {
                if (end - begin == t.length()) {
                    result.add(begin);
                }
                
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                begin++;
            }
        }
        return result;
    }
}
