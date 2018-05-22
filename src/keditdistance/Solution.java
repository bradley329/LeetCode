package keditdistance;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> kDistance(String[] words, String target, int k) {
        // Write your code here
		List<String> res = new ArrayList<>();
		if (words.length == 0) {
			return res;
		} else if (target.length() == 0) {
			for (int i = 0; i < words.length; i++) {
				if (words[i].length() <= k) {
					res.add(words[i]);
				}
			}
			return res;
		}
		for (int p = 0; p < words.length; p++) {
			String word = words[p];
			int len1 = word.length();
			int len2 = target.length();
			int[][] dp = new int[len1+1][len2+1];
			dp[0][0] = 0;
			for (int i = 1; i <= len1; i++) {
				dp[i][0] = i;
			}
			for (int j = 1; j <= len2; j++) {
				dp[0][j] = j;
			}
			for (int i = 1; i <= len1; i++) {
				for (int j = 1; j <= len2; j++) {
					if (word.charAt(i-1) == target.charAt(j-1)) {
						dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
					} else {
						dp[i][j] = Math.min(dp[i-1][j-1]+1, Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
					}
				}
			}
			if (dp[len1][len2] <= k) {
				res.add(word);
			}
		}
		return res;	
    }
}
