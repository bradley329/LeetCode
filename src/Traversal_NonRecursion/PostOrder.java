package Traversal_NonRecursion;

import java.util.*;
import maxtree.TreeNode;

// the most tricky one, push right first!
// all reversed compared to preorder!
public class PostOrder {
	public void pushAllRight(Stack<TreeNode> stack, TreeNode root, LinkedList<Integer> result) {
        while (root != null) {
            stack.push(root);
            result.addFirst(Integer.valueOf(root.val));
            root = root.right;
        }
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<Integer>();//注意这里要用linkedlist声明
        pushAllRight(stack, root, result);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                cur = cur.left;
                pushAllRight(stack, cur, result);
            }
        }
        return result;
    } 	
}
