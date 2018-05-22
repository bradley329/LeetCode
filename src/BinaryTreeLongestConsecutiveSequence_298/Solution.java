package BinaryTreeLongestConsecutiveSequence_298;

import maxtree.TreeNode;

public class Solution {
	public int longestConsecutive(TreeNode root) {
		return DFSHelper(root, null, 0);
	}
	
	private int DFSHelper(TreeNode cur, TreeNode parent, int len) {
		if (cur == null) {
			return 0;
		}
		if (parent != null && parent.val + 1 == cur.val) {
			len++;
		} else {
			len = 1;
		}
		int lenLeft = DFSHelper(cur.left, cur, len);
		int lenRight = DFSHelper(cur.right, cur, len);
		return Math.max(len, Math.max(lenLeft, lenRight));
	}
}
