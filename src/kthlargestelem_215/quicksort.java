package kthlargestelem_215;
//��û��swap
//��֤������ȷ�Ժܷ�ʱ�䣡
public class quicksort {
	private void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int key = arr[start];
			int left = start;
			int right = end;
			while (left < right) {
				while (left < right && arr[right] > key) {
					right --;
					// right points to the first element from back which <= key;
				}
				if (left < right) {
					// notice that we have already stored key;
					arr[left] = arr[right];
				}
				while (left < right && arr[left] <= key) {
					left ++;
				}
				if (left < right) {
					arr[right] = arr[left];
				}
			}
			arr[left] = key;
			quickSort(arr, start, left-1);
			quickSort(arr, right+1, end);
		}
	}
	
    public int findKthLargest(int[] nums, int k) {
    	quickSort(nums, 0, nums.length-1);
    	return nums[nums.length-k];
    }
}
