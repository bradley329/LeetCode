package lowestcommans_236;

import maxtree.TreeNode;

// even works when there are more than two nodes to find?
public class Simple {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		
		// post order:
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null; // never found!
    }
}
