package datastreammedian_295;

import java.util.Collections;
import java.util.PriorityQueue;

public class Lintcode_Solution {
	private PriorityQueue<Integer> maxHeap, minHeap;
	private int numOfelem;
	
	public int[] medianII(int[] nums) {
        // write your code here
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    	minHeap = new PriorityQueue<>();
    	numOfelem = 0;
    	int len = nums.length;
    	int[] ans = new int[len];
        for (int i = 0; i < len; ++i) {
            addNum(nums[i]);
            ans[i] = findMedian();
        }
        return ans;
    }
	public void addNum(int num) {
        //low是maxheap, high是minheap;
    	maxHeap.add(num);
    	//之前是奇还是偶；
    	//之前是偶，现在是奇
    	if (numOfelem % 2 == 0) {
            if (minHeap.isEmpty()) {
                numOfelem++;
                return;
            }
            else if (maxHeap.peek() > minHeap.peek()) {
                Integer leftmax = maxHeap.poll();
                Integer rightmin = minHeap.poll();
                maxHeap.add(rightmin);
                minHeap.add(leftmax);
            }
        }
        else {
            minHeap.add(maxHeap.poll());
        }
    	numOfelem++;
    }
    
    public int findMedian() {
    	return maxHeap.peek();
    }
}
