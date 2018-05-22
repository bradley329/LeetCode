package slidingwindowmax_239;

import java.util.ArrayDeque;
import java.util.Deque;

//��ʼ��Ϊ���ø�median�ǵ�����������뵽��PQ����TreeMap
//���ǣ������ֻҪ���ֵ������PQ�е���С��
public class Solution {
	//����ʵҲ����Ϊ�ı�֤˳���ˣ�
	//��Ϊwindow������Ų�ģ��������que.peekLast()<num����ô���Last���޳�ͷ֮��
	//ֱ�������
	public void inQueue(Deque<Integer> que, int num)
	{
		//��Ϊ��֤deque������first���
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
        //k is always valid, ie: 1 �� k �� input array's size for non-empty array.
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
