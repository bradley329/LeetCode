package LongestSubstringWithoutRepeatingCharacters_3;

import java.util.HashSet;

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    HashSet<Character> set = new HashSet<>();
    int len = s.length();
    int temp = 0;
    int max = 0;
    int i = 0, j = 0;
    while (j < len) {
      if (len - i <= max)
        break;
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j));
        temp++;
        j++;
      } else {
        max = Math.max(max, temp);
        set.remove(s.charAt(i));
        temp--;
        i++;
      }
    }
    max = Math.max(max, temp);
    return max;
  }
}
