package TrimBinarySearchTree_669;
import BinaryTree.TreeNode;

public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        TreeNode dummy = new TreeNode(0);
        dummy.right = root;
        dummy.right = helper(root, L, R);
        return dummy.right;
    }

    private TreeNode helper(TreeNode root, int l, int r) {
        if (root == null) return null;
        if (root.val > r) return helper(root.left, l, r);
        else if (root.val < l) return helper(root.right, l, r);
        else {
            root.left = helper(root.left, l, r);
            root.right = helper(root.right, l, r);
            return root;
        }
    }
}
