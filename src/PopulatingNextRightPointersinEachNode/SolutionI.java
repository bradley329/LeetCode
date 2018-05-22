package PopulatingNextRightPointersinEachNode;

// this code works when the binary tree is perfect.
public class SolutionI {
	public void connect(TreeLinkNode root) {
        if (root == null) {
			return;
		}
        TreeLinkNode parent = root;
        TreeLinkNode next_start = parent.left; // start node in next level;
        // since the binary tree is perfect, we could assert that if there is no next_start
        // there is no node in the next level;
        while (parent != null && next_start != null) {
			TreeLinkNode pre = null;
			// in this level, parent and pre keeps going => right;
			while (parent != null) {
				if (pre == null) {
					pre = next_start;
				} else {
					// need an extra step:
					pre.next = parent.left;
					pre = pre.next;
				}
				pre.next = parent.right;
				pre = pre.next;
				parent = parent.next;
			}
			// move cursor to the next level:
			parent = next_start;
			next_start = parent.left;
		}
    }
}
