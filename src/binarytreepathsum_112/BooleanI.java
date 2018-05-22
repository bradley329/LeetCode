package binarytreepathsum_112;

import maxtree.TreeNode;

public class BooleanI {
	 private boolean found;
	 private int subtreeSum;
	 public boolean hasPathSum(TreeNode root, int sum) {
	        found = false;
	        subtreeSum = 0;
	        Helper(root, sum);
			return found;
	    }
	    private void Helper(TreeNode root, int target) {
	    	if (root == null) {
				return;
			}
			//if this is a leaf?
	    	subtreeSum += root.val;
			if (root.left == null && root.right == null) {
				if (subtreeSum == target) {
					System.out.println("true le");
					found = true;
	                return;
				}
			}		
			Helper(root.left, target);
			Helper(root.right, target);
			subtreeSum -= root.val;
		}	   
}
