package kthsmallest;

import java.util.Comparator;
//PQÄ¬ÈÏÊÇmin_heap
import java.util.PriorityQueue;
import java.util.Queue;

public class priority {
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}			
		});
		int i=0;
		//code below is safe since k could not be zero!
		for(; i<k; i++) {
			pq.add(nums[i]);
		}
		for(i=k; i<nums.length; i++) {
			if(nums[i]<pq.peek()) {
				pq.remove();
				pq.add(nums[i]);
			}
		}
		return pq.peek();
    }
	
	/*public static void main(String[] args) {
		test();
	}*/
}
