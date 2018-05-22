package lowestcommans_236;

import maxtree.TreeNode;
// this is a general solotion if we r not finding two nodes, but more
public class Solution {
	private TreeNode ans = null;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return ans;
    }
    
    private int lca(TreeNode r, TreeNode p, TreeNode q) {
    	//is p or q possibly there?
        if (r == null) return 0;
        //this is the same idea as mine, to use n to mark 
        //whether we've found: (p or q) n=1; or (p and q) n=2;
        int found1 = lca(r.left, p, q); 
        if (found1 > 1) return 2;
        int found2 = lca(r.right, p, q);
        if (found2 > 1) return 2;
        //we do not rewrite ans[0] cuz n>2 indicates that we have already found them earlier! 
        int found = found1 + found2 + ((r == p || r == q) ? 1 : 0);
        if (found > 1) ans = r;
        return found;
    }
}
