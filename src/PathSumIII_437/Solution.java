package PathSumIII_437;

import java.util.*;

import BinaryTree.TreeNode;

public class Solution {
	private int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(root, 0, sum, map);
        return ans;
    }
    
    private void dfs(TreeNode root, int sub, int target, Map<Integer, Integer> map) {
        if(root == null) return;
        sub += root.val;
        ans += map.getOrDefault(sub-target, 0);
        map.put(sub, map.getOrDefault(sub, 0) + 1);
        dfs(root.left, sub, target, map);
        dfs(root.right, sub, target, map);
        // just like normal dfs or backtracking, this road is fully discovered
        // then do something before transfer to another road
        map.put(sub, map.get(sub) - 1);
    }
}
