package searchrangeinBST;

import java.util.*;

import maxtree.TreeNode;

public class Solution {
	/*
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
	private List<Integer> res;
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
    	res = new ArrayList<>();
    	InorderTraversal(root, k1, k2);
    	return res;
    }
    
    private void InorderTraversal(TreeNode root, int min, int max) {
    	if (root == null) {
            return;
        }
        if (root.val > min) {
        	InorderTraversal(root.left, min, max);
        }
        if (root.val >= min && root.val <= max) {
            res.add(root.val);
        }
        if (root.val < max) {
        	InorderTraversal(root.right, min, max);
        }
    }
}
