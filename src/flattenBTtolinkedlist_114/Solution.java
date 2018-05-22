package flattenBTtolinkedlist_114;

import maxtree.TreeNode;

public class Solution {
	TreeNode lastnode;
	public void flatten(TreeNode root) {
		if (root == null) {
            return;
        }

        if (lastnode != null) {
            lastnode.left = null;
            lastnode.right = root;
        }

        lastnode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
