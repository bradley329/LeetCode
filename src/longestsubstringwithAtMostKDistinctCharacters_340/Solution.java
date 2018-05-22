package longestsubstringwithAtMostKDistinctCharacters_340;

import java.util.HashMap;
//HashSet 不够用
//For example, Given s = "eceba", k = 3,
//可不可能就没答案？不可能，因为是at most；
public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
    	if(k <= 0) return 0;
    	int len = s.length();
    	int ans = 0, size = 0;
    	int i = 0, j = 0;
    	HashMap<Character, Integer> map = new HashMap<>();
    	for (; i < len; i++) {
			while (j < len) {
				if (!map.containsKey(s.charAt(j))) {
					if (size == k) {
						break;
					} else {
						map.put(s.charAt(j), 1);
						size++;
					}
				} else {
					map.put(s.charAt(j), map.get(s.charAt(j))+1);
				}
				j++;
			}
			ans = Math.max(ans, j-i);
			map.put(s.charAt(i), map.get(s.charAt(i))-1);
			if(map.get(s.charAt(i))==0){
				size--;
				map.remove(s.charAt(i));
			}
		}
    	return ans;
    }
}
