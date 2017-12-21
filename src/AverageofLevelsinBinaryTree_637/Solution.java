package AverageofLevelsinBinaryTree_637;

import BinaryTree.TreeNode;

import java.util.*;

/*Input:
        3
        / \
        9  20
        /  \
        15   7
        Output: [3, 14.5, 11]
        Explanation:
        The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].*/
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return null;
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> curtLevel = new LinkedList<>();
        curtLevel.add(root);
        while (!curtLevel.isEmpty()) {
            int size = curtLevel.size();
            double sum = 0.;
            double avg = 0.;
            TreeNode cur;
            for (int i = 0; i < size; i++) {
                cur = curtLevel.poll();
                // note: it is necessary!!! or size will be wrong!
                if (cur.left != null) {
                    curtLevel.add(cur.left);
                }
                if (cur.right != null) {
                    curtLevel.add(cur.right);
                }
                sum += cur.val;
            }
            avg = sum / size;
            res.add(avg);
        }
        return res;
    }
}
