package binaryTreeLevelOrder;

import java.util.*;

import maxtree.TreeNode;

public class SolutionII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> reslist = new ArrayList<>();
		if(root == null) return reslist;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> tplist = new ArrayList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int temp = queue.size();
            List<Integer>  sublist = new LinkedList<Integer>();
            for(int i = 0; i<temp; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            tplist.add(sublist);
        }
        for (int i = tplist.size()-1; i >= 0; i--) {
			reslist.add(tplist.get(i));
		}
        return reslist;
    }
}
