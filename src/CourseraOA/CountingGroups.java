package CourseraOA;

import java.util.*;

public class CountingGroups {
	private int n;
	private int m;
	private List<Integer> res;
	private int count;

	public List<Integer> numIslands(char[][] grid, int[] query) {
	    int count;
	    m = grid.length;// num of rows
	    if (m == 0) return res;
	    n = grid[0].length;// num of columns
	    res = new ArrayList<>();
	    Map<Integer, Integer> groupSize = new HashMap<>();
	    for (int i = 0; i < m; i++){
	        for (int j = 0; j < n; j++)
	            if (grid[i][j] == '1') {
	            	count = 0;
	                DFSMarking(grid, i, j);
	                groupSize.put(count, groupSize.getOrDefault(count, 0) + 1);
	            }
	    }    
	    for (int queryCount : query) {
	    	Integer querySize = groupSize.get(queryCount);
	    	if (querySize != null) {
	    		res.add(querySize);
			} else {
				res.add(0);
			}
	    }
	    return res;
	}

	private void DFSMarking(char[][] grid, int i, int j) {
		// below is something I've always been confused about:
		// the predication is sequential so grid[i][j] will not be overflowed?
	    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;
	    count++;
	    grid[i][j] = '0';
	    DFSMarking(grid, i + 1, j);
	    DFSMarking(grid, i - 1, j);
	    DFSMarking(grid, i, j + 1);
	    DFSMarking(grid, i, j - 1);
	}
}
