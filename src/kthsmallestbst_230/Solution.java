package kthsmallestbst_230;

import maxtree.TreeNode;

public class Solution {
	private int count = 0;
	private int ans = 0;
	public int kthSmallest(TreeNode root, int k) {
        //for a BST, in-order traversal gives the ordered sequences
		inOrderDFS(root, k);
		return ans;
    }
	
	private void inOrderDFS(TreeNode root, int k) {
		
		if (root == null || count > k) {
			return;
		}
		
		inOrderDFS(root.left, k);
		count++;
		
		if (count == k) {
			ans = root.val;
			return;
		}
		
		inOrderDFS(root.right, k);
	}
}
