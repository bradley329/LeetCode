package longestsubstringwithatleastkrepeat_395;

//http://www.lintcode.com/en/problem/longest-substring-with-at-most-k-distinct-characters/
//跟上面很不一样，上面的k限制的是不同字母的的个数，现在限制的是字母重复的个数
//因为你不知道后面会不会重复，所以要由大到小看
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
		//这个就很冗余，因为每个helper都要重新建。
		int[] count = new int[26];
		
		for (int i = st; i < end; i++) {
			count[str[i]-'a']++;
		}
		
		//寻找那个捣蛋鬼：
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
