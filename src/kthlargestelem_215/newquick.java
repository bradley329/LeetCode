package kthlargestelem_215;
//我们知道quicksort每一次，都能把pivot弄对；那么只要让k和pivot所在的index比较
//就可以divide conquer
public class newquick {
	
    public int findKthLargest(int[] nums, int k) {
    	return quickSort(nums, k, 0, nums.length-1);  	
	}
    
	private int quickSort(int[] nums, int k, int start, int end) {
		int len = nums.length;   	
    	if (start < end) {
			int key = nums[start];
			int left = start;
			int right = end;
			while (left < right) {
				while (left < right && nums[right] > key) {
					right --;
					// right points to the first element from back which <= key;
				}
				if (left < right) {
					// notice that we have already stored key;
					nums[left] = nums[right];
				}
				while (left < right && nums[left] <= key) {
					left ++;
				}
				if (left < right) {
					nums[right] = nums[left];
				}
			}
			nums[left] = key;
			if(k==len-left) return nums[left];
			else if(k<len-left) return quickSort(nums, k, left+1, end);
			else return quickSort(nums, k, start, left-1);//left-1 可能比start还小,但是好像没事
		}
    	return nums[start];
	}
}
