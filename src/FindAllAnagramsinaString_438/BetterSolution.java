package FindAllAnagramsinaString_438;

import java.util.*;

// this solution is more like mine idea, sliding window size fixed and then determine 
// if this sliding window satisfy the requirement
public class BetterSolution {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[26];
        for (char c : p.toCharArray()) hash[c-'a']++;
        // in hash, minus means dont need this character
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if(--hash[s.charAt(right) - 'a'] >= 0) {
            	count--;
            }
            right++; // note right points to the character which is the first outside the window
            if (count == 0) res.add(left); 
            // because of the below if condition
            // we could always make sure that the window size fixed at required length
            // so if count==0 is enough!
            if (right - left == p.length()) {
            	if(++hash[s.charAt(left)-'a'] > 0) {
            		count++;
            	}
            	left++;
            }
        }
        return res;
    }
}
