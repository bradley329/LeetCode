package wordbreak_139;

import java.util.*;

public class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>();
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (String word : wordDict) {
			dict.add(word);
			min = Math.min(min, word.length());            
            max = Math.max(max, word.length());
		}
		for (int i = 0; i <= s.length(); i++)
        {
            if (!dp[i]) continue;
            
            for (int j = i+min; j <= s.length() && j<=i+max; j++)
            {
                if (dict.contains(s.substring(i, j)))
                    dp[j] = true;
            }
        }
		return dp[s.length()];
	}
}
