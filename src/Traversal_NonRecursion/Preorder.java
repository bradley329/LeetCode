package Traversal_NonRecursion;

import java.util.*;

import maxtree.TreeNode;

public class Preorder {	
	public void pushAllLeft(Stack<TreeNode> stack, TreeNode root, List<Integer> result) {
	    while (root != null) {
	        stack.push(root);
	        //注意在
	        result.add(root.val);
	        root = root.left;
	    }
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        pushAllLeft(stack, root, result);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();//栈顶必定是已经添加到过结果里并且访问完了左孩子，该访问右孩子了
            if (cur.right != null) {
                cur = cur.right;
                pushAllLeft(stack, cur, result);
            }
        }
        return result;
    }
}
