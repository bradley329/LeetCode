package CompareVersionNumbers_165;

import java.util.*;

// will there be 1 and 1.0?
public class Solution {
	public int compareVersion(String version1, String version2) {
		// versions are non-empty
		String[] version_nums1 = version1.split("\\.");
		System.out.println(version_nums1[0]);
		List<Integer> nums1 = new ArrayList<>();
		for (int i = 0; i < version_nums1.length; i++) {
			nums1.add(Integer.parseInt(version_nums1[i]));
		}
		for (int i = nums1.size()-1; i >= 0; i--) {
			if (nums1.get(i) == 0) {
				nums1.remove(nums1.size()-1);
			} else {
				break;
			}
		}
		System.out.println(nums1.size());
		
		String[] version_nums2 = version2.split("\\.");
		List<Integer> nums2 = new ArrayList<>();
		for (int i = 0; i < version_nums2.length; i++) {
			nums2.add(Integer.parseInt(version_nums2[i]));
		}
		for (int i = nums2.size()-1; i >= 0; i--) {
			if (nums2.get(i) == 0) {
				nums2.remove(nums2.size()-1);
			} else {
				break;
			}
		}
		System.out.println(nums2.size());
		int idx = 0;
		while (idx < nums1.size() && idx < nums2.size()) {
			if (nums1.get(idx) < nums2.get(idx)) {
				return -1;
			} else if (nums1.get(idx) > nums2.get(idx)) {
				return 1;
			}
			idx++;
		}
		if (nums1.size() < nums2.size()) {
			return -1;
		} else if (nums1.size() > nums2.size()) {
			return 1;
		}
		return 0;
    }
	
	public static void main(String[] args) {
		System.out.println("add".split("\\.").length);
	}
}
