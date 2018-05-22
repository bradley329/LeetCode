package constructBT_106;

import maxtree.TreeNode;

public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int n = inorder.length;
        return helper(inorder, postorder, 0, n-1, 0, n-1);
    }
	
	private TreeNode helper(int[] inorder, int[] postorder, int st_in, int end_in, int st_post, int end_post) {
		if (st_in < 0 || end_in > inorder.length - 1 || st_in > end_in 
				|| st_post < 0 || end_post > postorder.length - 1 || st_post > end_post) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[end_post]);
		// search for root in inorder, try to get the separation of left and right subtree.
		int root_idx = 0;
		for (int i = st_in; i <= end_in; i++) {
			if (inorder[i] == root.val) {
				root_idx = i;
				break;
			}
		}
		int len_left = root_idx - st_in;
		int len_right = end_in - root_idx;
		root.left = helper(inorder, postorder, st_in, root_idx - 1, st_post, st_post + len_left - 1);
		root.right = helper(inorder, postorder, root_idx + 1, end_in, end_post - len_right, end_post - 1);
		return root;
	}
}
