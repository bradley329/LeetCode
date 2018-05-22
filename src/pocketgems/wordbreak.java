package pocketgems;

import java.util.*;

//��Ϊ�����ַ�����Ҫ�֣����Բ���Ҫdp[i][j]
//��������Ϊ���ж��ٸ�subarray�� ������s���Եģ��͵ö�ά
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
