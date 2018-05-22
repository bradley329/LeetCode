package datastreammedian_295;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    /** initialize your data structure here. */
	private PriorityQueue<Integer> maxHeap, minHeap;
	private int numOfelem;
    public MedianFinder() {
    	maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    	minHeap = new PriorityQueue<>();
    	numOfelem = 0;
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
    
    public double findMedian() {
    	return maxHeap.size() > minHeap.size() ? (double) maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) * 0.5;
    }
}