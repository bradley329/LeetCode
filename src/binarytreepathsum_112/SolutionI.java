package binarytreepathsum_112;

import java.util.ArrayList;
import java.util.List;

import maxtree.TreeNode;
//A valid path is from root node to any of the leaf nodes.
//�������һ��node���������һ������������������ļ򵥡�
//���͵�preorder
public class SolutionI {
	
	private List<Integer> temp;
	private List<List<Integer>> res;
	private int sum;
	
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
		sum = 0;
		temp = new ArrayList<>();
		res = new ArrayList<>();
		Helper(root, target);
		return res;
    }
	
	private void Helper(TreeNode root, int target) {
		if (root == null) {
			return;
		}
		//if this is a leaf?
		sum += root.val;
		temp.add(root.val);
		if (root.left == null && root.right == null) {
			if (sum == target) {
				res.add(new ArrayList<>(temp));
			}
		}		
		Helper(root.left, target);
		Helper(root.right, target);
		temp.remove(temp.size()-1);
		sum -= root.val;
	}
}
