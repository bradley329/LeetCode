package subtreewithmaximumaverage;

import maxtree.TreeNode;

//我们学的是直接在每个node上加上这些fields
class ResultType {
    public int sum, size;
    public ResultType(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
}

public class Solution {
    
    private TreeNode subtree = null;
    private ResultType subtreeResult = null;
    
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return subtree;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType result = new ResultType(
            left.sum + right.sum + root.val,
            left.size + right.size + 1
        );
        
        //尽量用乘法
        if (subtree == null ||
            subtreeResult.sum * result.size < result.sum * subtreeResult.size) {
            subtree = root;
            subtreeResult = result;
        }
        return result;
    }
}
