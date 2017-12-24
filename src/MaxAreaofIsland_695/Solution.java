package MaxAreaofIsland_695;

public class Solution {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) return res;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, DFSHelper(grid, i, j));
                }
            }
        }
        return res;
    }

    private int DFSHelper(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        // this one line if statement is awsome!
        if (i < 0 || i >= n || j <0 || j >= m || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int ret = 1;
        for (int k = 0; k < 4; k++) {
            int deltaX = dx[k];
            int deltaY = dy[k];
            ret += DFSHelper(grid, i + deltaX, j + deltaY);
        }
        return ret;
    }
}
