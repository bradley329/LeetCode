package pocketgems;

import maxtree.TreeNode;

public class InOrderSucc_BST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (p.right != null) {
			return leftMost(p.right);
		}
		TreeNode successor = null;
		while (root != null && root.val != p.val) {
			// find the first predecesor of p which has val > p.val
			if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        if (root == null) {
            return null;
        }
        return successor;
	}
	
	private TreeNode leftMost(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
}
