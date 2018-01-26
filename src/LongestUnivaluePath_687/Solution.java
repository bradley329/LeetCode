package LongestUnivaluePath_687;

import BinaryTree.TreeNode;

// the path should be parent to child or left-parent-right
public class Solution {
	int max = 0;
	public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }
	
	private int helper(TreeNode root) {
        if (root == null) {
			return 0;
		}
		int ret = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftRet = helper(left);
        int rightRet = helper(right);
        int leftPath = 0;
        int rightPath = 0;
        if (left != null) {
        	if (root.val == left.val) {
    			leftPath = leftRet + 1;
    		}
		}
        if (right != null) {
        	if (root.val == right.val) {
    			rightPath = rightRet + 1;
    		}
		}
        max = Math.max(max, leftPath + rightPath);
        ret = Math.max(leftPath, rightPath);
        return ret;
	}
}
