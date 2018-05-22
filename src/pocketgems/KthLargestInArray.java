package pocketgems;

import java.util.PriorityQueue;

public class KthLargestInArray {
	public int findKthLargest(int[] nums, int k) {
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		if (k > nums.length) {
			return 0;
		}
		
		for (int i = 0; i < k; i++) {
			minHeap.offer(nums[i]);
		}
		
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.offer(nums[i]);
			}
		}
		return minHeap.peek();
	}
	
	
	// quick select:
	public int findKthLargest2(int[] nums, int k) {
    	return quickSelect(nums, k, 0, nums.length-1, nums.length);  	
	}

	//其实是尾递归
	private int quickSelect(int[] nums, int k, int st, int end, int len) {
		if (st >= end) {
			return nums[st];
		} 
		
		int left = st;
		int right = end;
		int pivot = nums[st];
		while (left < right) {
			while (left < right && nums[right] > pivot) {
				right--;
			}
			if (left < right) {
				nums[left] = nums[right];
			}
			while (left < right && nums[left] <= pivot) {
				left++;
			}
			if (left < right) {
				nums[right] = nums[left];
			}
		}
		nums[left] = pivot;
		
		//注意：left为分界点
		if (k == len - left) {
			return nums[left];
		} else if (k < len - left) {
			return quickSelect(nums, k, left+1, end, len);
		} else {
			return quickSelect(nums, k, st, left-1, len);
		}
	}
}
