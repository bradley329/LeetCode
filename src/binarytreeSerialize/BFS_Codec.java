package binarytreeSerialize;

import java.util.*;

import maxtree.TreeNode;

public class BFS_Codec {
	public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        // why we chose to use a list?
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        // we use a list since we want to first store all valid node vals in the list
        // there is no "poll" in this section!
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        
        //consecutive nulls at the tail should be removed
        // if not, it's still correct
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        // i think maybe we could integrate this code block when we are first
        // procressing the list
        StringBuilder sb = new StringBuilder();
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("#")) {
            return null;
        }
        String[] vals = data.split(",");
        List<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int parentIdx = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(parentIdx).left = node;
                } else {
                    queue.get(parentIdx).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
            	parentIdx++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}
