package coverttoBST_108;

import maxtree.TreeNode;

public class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
			return null;
		}
        //长度为2怎么height balanced啊？
        int n = nums.length;
        return helper(nums, 0, n-1);
    }
	private TreeNode helper(int[] nums, int st, int end) {
		if (st > end) {
			return null;
		} else if (st == end) {
			return new TreeNode(nums[st]);
		}
		int mid = st + (end - st)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, st, mid-1);
		root.right = helper(nums, mid+1, end);
		return root;
	}
}
