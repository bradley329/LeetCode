package removeNodeinBST_450;

import maxtree.TreeNode;

public class Solution {
	public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        TreeNode parent = findNode(dummy, root, key);
        //parent is actually pre in my solution
        TreeNode node;
        //i used a boolean isleft in my solution
        if (parent.left != null && parent.left.val == key) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == key) {
            node = parent.right;
        } else {
            return dummy.left; //no found
        }
        
        deleteNode(parent, node);
        
        return dummy.left;
    }
    
    private TreeNode findNode(TreeNode parent, TreeNode node, int key) {
        if (node == null) {
            return parent;
        }
        
        if (node.val == key) {
            return parent;
        }
        if (key < node.val) {
            return findNode(node, node.left, key);
        } else {
            return findNode(node, node.right, key);
        }
    }
    
    private void deleteNode(TreeNode parent, TreeNode node) {
    	//I did not think of predicating node.right first
    	//"no need to sind the last one" in left!!!
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            TreeNode temp = node.right;
            TreeNode father = node;
            
            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }
            
            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }
            
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            
            temp.left = node.left;
            temp.right = node.right;
        }
    }
}
