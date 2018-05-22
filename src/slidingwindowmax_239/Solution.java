package slidingwindowmax_239;

import java.util.ArrayDeque;
import java.util.Deque;

//开始因为觉得跟median那道差不多所以先想到了PQ甚至TreeMap
//但是，这个题只要最大值，所以PQ有点大材小用
public class Solution {
	//但其实也是人为的保证顺序了！
	//因为window是往右挪的，所以如果que.peekLast()<num，那么这个Last永无出头之日
	//直接舍掉；
	public void inQueue(Deque<Integer> que, int num)
	{
		//人为保证deque有序，且first最大！
		while (!que.isEmpty() && que.peekLast() < num) {
			que.pollLast();
		}
		que.offer(num);
	}
	
	public void outQueue(Deque<Integer> que, int num)
	{
		if (que.peekFirst() == num) {
			que.pollFirst();
		}
	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        //why we use queue is because there could be multiple same maximums.
        //k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
        int[] ans = new int[nums.length - k + 1];
        if (nums.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < k - 1; i++) {
            inQueue(maxDeque, nums[i]);
        }
        
        for(int i = k - 1; i < nums.length; i++) {
            inQueue(maxDeque, nums[i]);
            ans[i-k+1] = maxDeque.peekFirst();
            outQueue(maxDeque, nums[i - k + 1]);
        }
        return ans;
    }
}
