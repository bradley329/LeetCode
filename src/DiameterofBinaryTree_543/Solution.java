package DiameterofBinaryTree_543;

import BinaryTree.TreeNode;

/*Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.*/

public class Solution {
	private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        recHelper(root);
        return max;
    }
    
	private int recHelper(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int left = recHelper(root.left);
		int right = recHelper(root.right);
		max = Math.max(max, left + right + 2); 
		return Math.max(left, right) + 1;
	}
}
