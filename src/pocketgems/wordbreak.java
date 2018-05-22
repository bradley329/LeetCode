package pocketgems;

import java.util.*;

//因为整个字符串都要分，所以不需要dp[i][j]
//如果此题改为求有多少个subarray， 是满足s特性的，就得二维
public class wordbreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		// pac man style dp
		if(s==null||s.length()==0) return false;
		if(wordDict.size()==0) return false;
		boolean dp[] = new boolean[s.length()+1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
