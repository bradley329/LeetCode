package binarytreeinorder_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import maxtree.TreeNode;

public class Iterative {
	Stack<TreeNode> stack = new Stack<>();
	public List<Integer> inorderTraversal(TreeNode root) {		
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		pushLeftTostack(root);
		while (!stack.isEmpty()) {
			TreeNode left = stack.pop();
			res.add(left.val);
			pushLeftTostack(left.right);
		}
		return res;
	}
	
	//push the left children:
	private void pushLeftTostack(TreeNode root) {
		if (root == null) {
			return;
		}
		stack.push(root);
		while (root.left != null) {
			stack.push(root.left);
			root = root.left;
		}
	}
}
