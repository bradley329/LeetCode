package numberofisland_200;

import java.util.LinkedList;
import java.util.Queue;
class Pair {
	int x,y;
	public Pair(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}

public class BFS {
    private int n;
	private int m;
	private char[][] gd;
	
	public int numIslands(char[][] grid) {
	    int count = 0;
	    gd = grid;
	    m = grid.length;// num of rows
	    if (m == 0) return 0;
	    n = grid[0].length;// num of columns
	    for (int i = 0; i < m; i++){
	        for (int j = 0; j < n; j++)
	            if (gd[i][j] == '1') {
	                BFSMarking(i, j);
	                count++;
	            }
	    }   
	    return count;
	}
	
	private void BFSMarking(int x, int y) {
		int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};      
    	Queue<Pair> que = new LinkedList<>();       
        que.offer(new Pair(x, y));
        gd[x][y] = '0';
        
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            for (int k = 0; k < 4; k++) {
                Pair adj = new Pair(pair.x + dx[k], pair.y + dy[k]);
                if (!inBound(adj)) {
                    continue;
                }
                if (gd[adj.x][adj.y]=='1') {
                    gd[adj.x][adj.y] = '0';
                    que.offer(adj);
                }
            }
        }
	}
	
	private boolean inBound(Pair pair) {      
        return pair.x >= 0 && pair.x < m && pair.y >= 0 && pair.y < n;
    }
}
