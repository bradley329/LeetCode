package numberofisland_200;
//仔细分析这个dfs的递归，会发现类似尾递归，所以stack相当于废掉了。
public class DFS {
    private int n;
	private int m;

	public int numIslands(char[][] grid) {
	    int count = 0;
	    m = grid.length;// num of rows
	    if (m == 0) return 0;
	    n = grid[0].length;// num of columns
	    for (int i = 0; i < m; i++){
	        for (int j = 0; j < n; j++)
	            if (grid[i][j] == '1') {
	                DFSMarking(grid, i, j);
	                count++;
	            }
	    }    
	    return count;
	}

	private void DFSMarking(char[][] grid, int i, int j) {
		// below is something I've always been confused about:
		// the predication is sequential so grid[i][j] will not be overflowed?
	    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;
	    grid[i][j] = '0';
	    DFSMarking(grid, i + 1, j);
	    DFSMarking(grid, i - 1, j);
	    DFSMarking(grid, i, j + 1);
	    DFSMarking(grid, i, j - 1);
	}
}
