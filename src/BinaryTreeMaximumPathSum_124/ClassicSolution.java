package BinaryTreeMaximumPathSum_124;

import maxtree.TreeNode;

public class ClassicSolution {
	private class ResultType {
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer
        int singlePath =
            Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath,
                           Math.max(left.singlePath, 0) + 
                           Math.max(right.singlePath, 0) + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}
