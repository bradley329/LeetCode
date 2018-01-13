package TwoSumIV_InputisaBST;

import BinaryTree.TreeNode;
/*为了利用bst的特性，
是抓住一个不动。target就是k - firstNode.val; 然后根据bst的特性找另一个node
*/
public class LeetSolution {
	public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
	
	private boolean dfs(TreeNode root, TreeNode firstNode, int k){
		if (firstNode == null) return false;
        // grab the first node and search for a second node
        return search(root, firstNode, k - firstNode.val) || dfs(root, firstNode.left, k) || dfs(root, firstNode.right, k);
    }
	
    private boolean search(TreeNode root, TreeNode firstNode, int k){
        if(root == null) return false;
        else if (root != firstNode && root.val == k) return true;
        else if (root.val > k) return search(root.left, firstNode, k);
        else return search(root.right, firstNode, k);
    }
}
