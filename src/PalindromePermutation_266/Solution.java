package PalindromePermutation_266;

import java.util.*;

public class Solution {
	public boolean canPermutePalindromeI(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        for (char c : s.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
            	cnt++;
            }
        }
        return cnt == 0 || (s.length() % 2 == 1 && cnt == 1);
    }
	
	// using set is fairly enough
	// characters appeared even times will not be in the set
	// and which appeared odd times will in the set.
	public boolean canPermutePalindromeII(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) set.remove(c);
        }
        return set.isEmpty() || set.size() == 1;
    }
	
	public static void main(String[] args) {
		
	}
}
