package BinaryTreeMaximumPathSum_124;

import Traversal_NonRecursion.Preorder;
import maxtree.TreeNode;

// note: this solution does not right!!!
// in pre order, since we store each node's current max value in the call stack,
// so we dont need a ResultType tuple to return to the upper level.
class Tuple {
	public int max_include; // 
	public int max_global;
	public Tuple(int max_include, int max_global) {
		this.max_global = max_global;
		this.max_include = max_include;
	}
}

public class PreOrderSolution {
	private int res;
	public int maxPathSum(TreeNode root) {
        if (root == null) {
			return 0;
		}
        PreOrderHelper(root, 0, 0);
        return res;
    }
	
	private void PreOrderHelper(TreeNode root, int max_include, int max_global) {
		if (root == null) {
			res = Math.max(res, max_global);
			return;
		}
		int singlePath = Math.max(0, max_include) + root.val; // zero here is easy but trivial
		// at least have root.val;
        int maxPath = Math.max(max_global, singlePath);
        PreOrderHelper(root.left, singlePath, maxPath);
        PreOrderHelper(root.right, singlePath, maxPath);
	}
}
