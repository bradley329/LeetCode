package trianglecount;

import java.util.Arrays;

//Sort以后用two pointer就可以偷懒
//揪住第三个 动另外两个的two pointers的问题好像见了不少， three sum？
public class Solution {
	/**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        int one = 0, two = S.length - 1;
        int ans = 0;
        Arrays.sort(S);
        for(int three = 2; three < S.length; three++) {
            one = 0;
            two = three - 1;
            while(one < two) {
                if(S[one] + S[two] > S[three]) {
                    ans = ans + (two - one);
                    two--;
                } else {
                    one++;
                }
            }
        }
        return ans;
    }
}
