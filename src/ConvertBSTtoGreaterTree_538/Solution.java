package ConvertBSTtoGreaterTree_538;

import BinaryTree.TreeNode;

// a reverse inorder traversal of BST gives nodes in "descending" order.
public class Solution {
	int postSum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    
    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += postSum;
        postSum = cur.val;
        convert(cur.left);
    }
}
