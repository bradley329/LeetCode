package kthlargestelem_215;

//PQÄ¬ÈÏÊÇmin_heap
import java.util.PriorityQueue;
import java.util.Queue;

public class priority {
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<>(k);
		int i=0;
		//code below is safe since k could not be zero!
		for(; i<k; i++) {
			pq.add(nums[i]);
		}
		for(i=k; i<nums.length; i++) {
			if(nums[i]>pq.peek()) {
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
