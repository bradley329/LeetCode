package binarytreezigzag_103;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import maxtree.TreeNode;
//Must use stack!! Queue is wrong!
public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> curStk = new Stack<>();
		Stack<TreeNode> nextStk = new Stack<TreeNode>();
		Stack<TreeNode> tp;
		boolean left_to_right = true; //this means "cur level" is lefttoright
		curStk.add(root);
		while (!curStk.isEmpty()) {
			List<Integer> cur_res = new ArrayList<>();
			while (!curStk.isEmpty()) {
				TreeNode curNode = curStk.pop();
				cur_res.add(curNode.val);				 
				//notice if(left_to_right), since we are using stack, so still 
				//should add to next level stack lefttoright!
				if (left_to_right) { 
					if (curNode.left != null) {
						nextStk.add(curNode.left);
					}
					if (curNode.right != null) {
						nextStk.add(curNode.right);
					}
				} else {
					if (curNode.right != null) {
						nextStk.add(curNode.right);
					}
					if (curNode.left != null) {
						nextStk.add(curNode.left);
					}
				}				
			}
			res.add(cur_res);
			tp = curStk;
			curStk = nextStk;
			nextStk = tp; //which should be blank at this point.	
			left_to_right = !left_to_right;
		}
		return res;		
    }
}
