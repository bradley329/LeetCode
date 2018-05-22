package binarytreepathsum_112;

import java.util.*;

import maxtree.TreeNode;

public class BetterSolutionII {
	private int ans = 0;
	private Map<Integer, Integer> map;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        map = new HashMap<>();
        map.put(0, 1);
        dfs(root, 0, sum);
        return ans;
    }
    private void dfs(TreeNode root, int sub, int target) {
        if(root == null) return;
        sub += root.val;
        //还是 我踢到前面一些是否还能等于target?
        ans += map.getOrDefault(sub-target, 0);
        map.put(sub, map.getOrDefault(sub, 0) + 1);
        dfs(root.left, sub, target);
        dfs(root.right, sub, target);
        map.put(sub, map.get(sub) - 1);
    }
}
