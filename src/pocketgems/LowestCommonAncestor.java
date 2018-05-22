package pocketgems;

import maxtree.TreeNode;

public class LowestCommonAncestor {
	// BST:
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null) return root;
		if((p.val<root.val&&q.val>root.val)||(p.val>root.val&&q.val<root.val)){
			return root;
		}
		else if(p.val<root.val&&q.val<root.val){
			return lowestCommonAncestor(root.left,p,q);
		}
		else{
			return lowestCommonAncestor(root.right,p,q);
		}
	}
	
	// BT:
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null){
			return null;
		}
		if(root == p || root == q){
			return root;
		}
		TreeNode l = lowestCommonAncestor(root.left,p,q);
		TreeNode r = lowestCommonAncestor(root.right,p,q);
		if(l != null && r != null){
			return root;
		}
		return l != null ? l:r;
	}
}
