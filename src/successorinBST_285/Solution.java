package successorinBST_285;

import maxtree.TreeNode;

public class Solution {
	TreeNode pre;
	TreeNode res;
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		pre = null;
		res = null;
		inorderHelper(root, p);
		return res;
	}
	
	private void inorderHelper(TreeNode root, TreeNode p) {
		if (root == null) {
			return;
		}
		inorderHelper(root.left, p);
		if (pre == p) {
			res = root;
			return;
		}
		pre = root;
		inorderHelper(root.right, p);
	}
}
