package LongestRepeatingCharacterReplacement_424;

public class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        //corner case:
        if (k >= len-1) {
			return len;
		}
        //max of counts of all characters
        int max = 0;
        //bitmap for each char's count
        int[] count = new int[26];
        int res = 0;
        int st = 0;
        for (int end=0; end < s.length(); end++) {
        	max = Math.max(max, count[s.charAt(end)-'A']++);
        	if (end-st+1-max > k) {
        		count[s.charAt(st)-'A']--;
				st++;
			}
        	res = Math.max(res, end-st+1);
        }
        return res;
    }
}
