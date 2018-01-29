package MinimumAbsoluteDifferenceinBST_530;

import BinaryTree.TreeNode;

// inOrder traverse the BST and compare the delta between each of the adjacent values.
// It¡¯s guaranteed to have the correct answer 
public class Solution {
    private int min = Integer.MAX_VALUE;
    private TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(pre != null){
            min = Math.min(min, root.val-pre.val);
        }
        pre = root;
        inorder(root.right);
    }
}
