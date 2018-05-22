package medianTwoSortedArray_4;

//套用了找两个sorted array第k大的数的解法
//this BS is to binary k not (m+n)
//但其实median的那个解法是最好的 因为他是一定要舍掉一半
public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length + nums2.length;
		if (len % 2 == 0) {
			double left = (double) helper(nums1, 0, nums2, 0, len/2);
			double right = (double) helper(nums1, 0, nums2, 0, len/2+1);
			return left + (right - left)/2;
		} else {
			return (double) helper(nums1, 0, nums2, 0, len/2+1);
		}
	}
	
	private int helper(int[] a, int aStart, int[] b, int bStart, int k) {
		if (aStart >= a.length) {
			return b[bStart+k-1];
		}
		if (bStart >= b.length) {
			return a[aStart+k-1];
		}
		if (k == 1) {
			return Math.min(a[aStart], b[bStart]);			
		}
		int aVal = aStart + k/2 - 1 >= a.length ? Integer.MAX_VALUE : a[aStart + k/2-1];
		int bVal = bStart + k/2 - 1 >= b.length ? Integer.MAX_VALUE : b[bStart + k/2-1];
		if (aVal < bVal) {
			return helper(a, aStart+k/2, b, bStart, k-k/2);
		} else {
			return helper(a, aStart, b, bStart+k/2, k-k/2);
		}
	}
}
