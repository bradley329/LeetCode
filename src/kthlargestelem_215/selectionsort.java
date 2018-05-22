package kthlargestelem_215;

import java.util.*;
// find or search better not modify the original array; 
public class selectionsort {
	public static int[] selectSortK(int[] arr, int k) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		int[] newArr = new int[k];
		List<Integer> list = new ArrayList<Integer>();//记录每次最大数的下标
		for (int i=0; i<k; i++) {
			int maxValue = Integer.MIN_VALUE; //最大值
			int maxIndex = i; 
			for (int j=0; j<arr.length; j++) {
				if (arr[j] > maxValue && !list.contains(j)) {
					maxValue = arr[j];
					maxIndex = j;
				}
			}
			if (!list.contains(maxIndex)) {//如果不存在，就加入
				list.add(maxIndex);
				newArr[i] = maxValue;
			}
		}
		return newArr;
	}
	
	public int findKthLargest(int[] nums, int k) {
    	selectSortK(nums, k);
    	return nums[k-1];
    }

}
