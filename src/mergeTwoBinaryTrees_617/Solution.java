package mergeTwoBinaryTrees_617;

import maxtree.TreeNode;

public class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
			return null;
		} else if (t1 == null) {
			return copySubtree(t2);
		} else if (t2 == null) {
			return copySubtree(t1);
		} else {
			TreeNode copy = new TreeNode(t1.val + t2.val);
			copy.left = mergeTrees(t1.left, t2.left);
			copy.right = mergeTrees(t1.right, t2.right);
			return copy;
		}
    }
	
	private TreeNode copySubtree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode copy = new TreeNode(root.val);
		copy.left = copySubtree(root.left);
		copy.right = copySubtree(root.right);
		return copy;
	}
}
