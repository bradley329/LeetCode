package binarytreepathsum_112;

import java.util.*;

import maxtree.TreeNode;

public class SolutionII {
	
    private List<List<Integer>> res;
    private List<Integer> buffer;
    
	public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
		res = new ArrayList<>();
		buffer = new ArrayList<>();
        if (root == null)
            return res;
        findSum(root, target, 0);
        return res;
    }

    public void findSum(TreeNode head, int target, int level) {
        if (head == null) return;
        int sum = target;
        buffer.add(head.val);
        //ÍùÇ°ÕÒÆðµã;
        for (int i = level; i >= 0; i--) {
            sum -= buffer.get(i);
            if (sum == 0) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int j = i; j <= level; j++)
                    temp.add(buffer.get(j));
                res.add(temp);
            }
        }
        findSum(head.left, target, level + 1);
        findSum(head.right, target, level + 1);
        buffer.remove(buffer.size() - 1);
    }
}
