package Traversal_NonRecursion;

import java.util.*;

import maxtree.TreeNode;

public class Preorder {	
	public void pushAllLeft(Stack<TreeNode> stack, TreeNode root, List<Integer> result) {
	    while (root != null) {
	        stack.push(root);
	        //ע����
	        result.add(root.val);
	        root = root.left;
	    }
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        pushAllLeft(stack, root, result);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();//ջ���ض����Ѿ���ӵ�������ﲢ�ҷ����������ӣ��÷����Һ�����
            if (cur.right != null) {
                cur = cur.right;
                pushAllLeft(stack, cur, result);
            }
        }
        return result;
    }
}
