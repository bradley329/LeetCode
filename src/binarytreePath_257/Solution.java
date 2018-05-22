package binarytreePath_257;

import java.util.*;

import maxtree.TreeNode;

public class Solution {
	
	private List<String> ll = new ArrayList<>();
	
    public List<String> binaryTreePaths(TreeNode root) {
    	if(root==null) return ll;
    	
    	if(root.left==null && root.right==null) {
    		ll.add(Integer.toString(root.val));
    		return ll;
    	}
    	
    	String str = Integer.toString(root.val);
        if (root.left != null) {
        	helper(str, root.left);
        }
        
        if (root.right != null) {
        	helper(str, root.right);
        }
        return ll;
    }
    
    private void helper(String str, TreeNode root) {
    	if (root.left==null && root.right==null) {
    		ll.add(str+"->"+Integer.toString(root.val)); 
    		return;
    	}
    	if (root.left!=null) {
    		helper(str+"->"+Integer.toString(root.val), root.left);
    	}
    	if (root.right!=null) {
    		helper(str+"->"+Integer.toString(root.val), root.right);
    	}
    }
}
