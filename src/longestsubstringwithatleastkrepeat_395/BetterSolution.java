package longestsubstringwithatleastkrepeat_395;

public class BetterSolution {
	public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int end = s.length()-1;
        
        return helper(0, end, s, k);
    }
    
    private int helper(int start, int end, String s, int k){
        if(end -start +1 < k) return 0;
        
        char[] chars = new char[26];
        for(int i=start; i<=end; i++){
            chars[s.charAt(i)-'a']++;
        }
        
        boolean less = false;
        for(int j =0; j<26; j++){
            if(chars[j] !=0 && chars[j]<k) less =true;
        }
        //all the s is valid
        if(!less) return end-start+1;
        
        // otherwise we use all the infrequent elements as splits
        //这个地方算是一个优化。没有必要分左右。是有重复的
        int l = start, r=l;
        int max = 0;
        while(r <= end){
            if(chars[s.charAt(r)-'a'] !=0 && chars[s.charAt(r)-'a']<k){
                max = Math.max(helper(l, r-1, s, k), max);
                l = r+1;
            }
            r++;
        }
        //compare the last part of the string
        return Math.max(max, helper(l, end, s, k));
    }
}
