package twitterOA;

import java.util.*;

public class longestphrasesinatweet {
	static int maxLength(int[] a, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int maxLen = 0;
        for(int cur : a){
            if(sum + cur <= k){
                queue.offer(cur);
                sum += cur;
            }else{      
                while(sum + cur > k){
                    maxLen = Math.max(maxLen, queue.size());
                    int first = queue.poll();
                    sum -= first;
                }
                sum += cur;
                queue.offer(cur);
//                maxLen = Math.max(maxLen, queue.size());
            }
        }
        maxLen = Math.max(maxLen, queue.size());
        return maxLen;
    }
}
