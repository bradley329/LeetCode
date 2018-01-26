package ConstructStringfromBinaryTree_606;

import BinaryTree.TreeNode;
// the running time is too large
public class Solution {
	private static String res;
    public static String tree2str(TreeNode t) {
        if (t == null) {
			return "()";
		}
        res = Integer.toString(t.val);
        DFSHelper(t);
        return res;
    }

	private static void DFSHelper(TreeNode parent) {
		TreeNode left = parent.left;
		TreeNode right = parent.right;
		if (left == null && right == null) {
			return;
		} else {
			if (left == null) {
				// right is not null
				res += "()("; //left must be represented as "()";
				res += Integer.toString(right.val);
				DFSHelper(right);
				res += ")";
			} else if (right == null) {
				res += "(";
				res += Integer.toString(left.val);
				DFSHelper(left);
				res += ")";
			} else {
			// both are not null
				res += "(";
				res += Integer.toString(left.val);
				DFSHelper(left);
				res += ")";
				res += "(";
				res += Integer.toString(right.val);
				DFSHelper(right);
				res += ")";
			}
		} 
	}
	
	public static void main(String[] args) {
		
	}
}
