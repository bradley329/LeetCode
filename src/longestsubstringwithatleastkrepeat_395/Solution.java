package longestsubstringwithatleastkrepeat_395;

//http://www.lintcode.com/en/problem/longest-substring-with-at-most-k-distinct-characters/
//������ܲ�һ���������k���Ƶ��ǲ�ͬ��ĸ�ĵĸ������������Ƶ�����ĸ�ظ��ĸ���
//��Ϊ�㲻֪������᲻���ظ�������Ҫ�ɴ�С��
public class Solution {
	public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, str.length, k);
    }
	
	private int helper(char[] str, int st, int end, int k) {
		//base case
		if (end-st < k) {
			return 0;
		}
		//����ͺ����࣬��Ϊÿ��helper��Ҫ���½���
		int[] count = new int[26];
		
		for (int i = st; i < end; i++) {
			count[str[i]-'a']++;
		}
		
		//Ѱ���Ǹ�������
		for (int i = 0; i < 26; i++) {			
			if (count[i] < k && count[i] > 0) {
				char outlier = (char) (i +'a');				
				for (int j = st; j < end; j++) {
					if(str[j] == outlier){
	                    int left = helper(str, st, j, k);
	                    int right = helper(str, j+1, end, k);
	                    return Math.max(left, right); 
	                }
				}
			}
		}
		return end - st;
	}
}
