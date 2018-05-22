import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import maxtree.TreeNode;

public class inordersuccessorBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    if(root==null || p==null)
	        return null;
	 
	    stack.push(root);
	    boolean isNext = false;
	    while(!stack.isEmpty()){
	        TreeNode top = stack.pop();
	        //为了保证这个是已经visited过得
	        //即仿照inorder的按照递归出来的顺序
	        if(top.right==null&&top.left==null){
	            if(isNext){
	                return top;
	            }
	 
	            if(p.val==top.val){
	                isNext = true;
	            }
	            continue;
	        }
	 
	        if(top.right!=null){
	            stack.push(top.right);
	            top.right=null;
	        }
	 
	        stack.push(top);
	 
	        if(top.left!=null){
	            stack.push(top.left);
	            top.left=null;
	        }
	    }
	 
	    return null;
	}
}
