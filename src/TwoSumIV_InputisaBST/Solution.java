package TwoSumIV_InputisaBST;

import java.util.*;

import BinaryTree.TreeNode;

// this is the general version, did not make use of BST
public class Solution {
	public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }
    
    public boolean dfs(TreeNode root, Set<Integer> set, int k){
        if(root == null) return false;
        if(set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
}
