package binaryTreeLevelOrder;

import java.util.*;
import maxtree.TreeNode;

//from top to bottom:
public class SolutionI {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> reslist = new ArrayList<List<Integer>>();
        
        if(root == null) return reslist;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int temp = queue.size();
            List<Integer>  sublist = new LinkedList<Integer>();
            for(int i = 0; i<temp; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            reslist.add(sublist);
        }
        
        return reslist;
    }
}
