package removeNodeinBST_450;

import maxtree.TreeNode;

//last in left subtree(right most) or first in right subtree(left most)
public class MLESolution {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		TreeNode dummyhead = new TreeNode(0);
		dummyhead.left = root;
		TreeNode pre = dummyhead;
		boolean preisleft = true;
		TreeNode cur = root;
		while (cur.val != key && cur != null) {
			pre = cur;
			if (key < cur.val) {
				cur = cur.left;
				preisleft = true;
			} else {
				cur = cur.right;
				preisleft = false;
			}
			
		}
		
		if (cur != null) {
			// now cur.val = key;
			TreeNode left = cur.left;
			TreeNode right = cur.right;
			if (left != null) {
				if (left.right == null) {
					TreeNode lleft = left.left;
					cur.left = lleft;
					left.left = cur.left;
					left.right = cur.right;
					cur = left;
				} else {
					TreeNode Lpre = left;
					while (left.right != null) {
						Lpre = left;
						left = left.right;
					}
					TreeNode lleft = left.left;
					pre.right = lleft;
					left.left = cur.left;
					left.right = cur.right;
					cur = left;		
					System.out.println(cur.val);
				}
				
			} else if (right != null) {
				if (right.left == null) {
					TreeNode rright = right.right;
					cur.right = rright;
					right.left = cur.left;
					right.right = cur.right;
					cur = right;
				} else {
					TreeNode Rpre = right;
					while (right.left != null) {
						Rpre = right;
						right = right.left;
					}
					TreeNode rright = right.right;
					pre.left = rright;
					right.left = cur.left;
					right.right = cur.right;
					cur = right;					
				}
				
			} else {
				//just delete cur
				cur = null;
			}
			if (preisleft) {
				pre.left = cur;
			} else {
				pre.right = cur;
			}
		}
		return dummyhead.left;
	}
}
