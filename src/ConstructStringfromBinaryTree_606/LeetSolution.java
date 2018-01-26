package ConstructStringfromBinaryTree_606;

import BinaryTree.TreeNode;

// used StringBuilder
// nearly the same as mine
// but more concise and clear!
public class LeetSolution {
	public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        DFSHelper(t, sb);
        return sb.toString();
    }
    
    private void DFSHelper(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            sb.append("(");
            DFSHelper(root.left, sb);
            sb.append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            DFSHelper(root.right, sb);
            sb.append(")");
        }
    }
}
