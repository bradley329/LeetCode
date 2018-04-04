package Oath;

// Remove all nodes which have values smaller than target in a BST.
import BinaryTree.TreeNode;
public class Solution {
	public TreeNode removeSmallerNodes(TreeNode root, int target) {
		TreeNode dummy = new TreeNode(-1);
		dummy.right = root;
		removeHelper(root, target);
		return dummy.right;
	}
	
	private TreeNode removeHelper(TreeNode root, int target) {
		if (root == null) {
			return null;
		}
		if (root.val < target) {
			return removeHelper(root.right, target);
		} else if (root.val == target) {
			root.right = removeHelper(root.right, target);
			return root;
		} else {
			root.left = removeHelper(root.left, target);
			root.right = removeHelper(root.right, target);
			return root;
		}
	}
}
