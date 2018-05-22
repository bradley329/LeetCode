package kthlargestelem_215;

import java.util.*;
// find or search better not modify the original array; 
public class selectionsort {
	public static int[] selectSortK(int[] arr, int k) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		int[] newArr = new int[k];
		List<Integer> list = new ArrayList<Integer>();//��¼ÿ����������±�
		for (int i=0; i<k; i++) {
			int maxValue = Integer.MIN_VALUE; //���ֵ
			int maxIndex = i; 
			for (int j=0; j<arr.length; j++) {
				if (arr[j] > maxValue && !list.contains(j)) {
					maxValue = arr[j];
					maxIndex = j;
				}
			}
			if (!list.contains(maxIndex)) {//��������ڣ��ͼ���
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
