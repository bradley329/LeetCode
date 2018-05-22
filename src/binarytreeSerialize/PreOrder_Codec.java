package binarytreeSerialize;

import java.util.*;

import maxtree.TreeNode;

//based on preorder
//since when we encountered NN, we know that we must
public class PreOrder_Codec {
	private static final String delimiter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        //System.out.println(sb.toString());
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(delimiter);
        } else {
        	//pre-order traversal
            sb.append(node.val).append(delimiter);
            //this way, "," will be at the end position  
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	//double ended queue enables null insertions
        List<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(delimiter)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(List<String> nodes) {
        String val = nodes.remove(0);
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
