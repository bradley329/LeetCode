package buildpostoffice;

import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//this is the solution based on houses.
//which means we select houses and BFS all the blank spaces
//and for all the blank spaces, we plus the distance to it's total distance to all the houses;
//finally, we just need to select the blank space which has the smallest total distance.
public class SolutionI {
	public final int EMPTY = 0;
    public final int HOUSE = 1;
    public final int WALL = 2;
    public int[][] grid;
    public int n, m;
    public int[] deltaX = {0, 1, -1, 0};
    public int[] deltaY = {1, 0, 0, -1};
    
    private void setGrid(int[][] grid) {
    	this.grid = grid;
    	this.n = grid.length;
    	this.m = grid[0].length;
    }
    
    private List<Pair> getPairsforType(int type) {
    	List<Pair> pairs = new ArrayList<>();
    	
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == type) {
                    pairs.add(new Pair(i, j));
                }
            }
        }
        
        return pairs;
    }
    
    private boolean inBound(Pair coor) {
        if (coor.x < 0 || coor.x >= n) {
            return false;
        }
        if (coor.y < 0 || coor.y >= m) {
            return false;
        }
        return grid[coor.x][coor.y] == EMPTY;
    }
    
    private void BFSMarking(Pair start,
            int[][] distanceSum,
            int[][] visitedTimes) {
		Queue<Pair> queue = new LinkedList<>();
		boolean[][] hash = new boolean[n][m];
		
		queue.offer(start);
		hash[start.x][start.y] = true;
		
		int steps = 0;
		while (!queue.isEmpty()) {
		   steps++;
		   int size = queue.size();
		   for (int temp = 0; temp < size; temp++) {
		       Pair coor = queue.poll();
		       for (int i = 0; i < 4; i++) {
		    	   Pair adj = new Pair(
		               coor.x + deltaX[i],
		               coor.y + deltaY[i]
		           );
		           if (!inBound(adj)) {
		               continue;
		           }
		           if (hash[adj.x][adj.y]) {
		               continue;
		           }
		           queue.offer(adj);
		           hash[adj.x][adj.y] = true;
		           distanceSum[adj.x][adj.y] += steps;
		           visitedTimes[adj.x][adj.y]++;
		       }
		   } 
		}
    }
    
    public int shortestDistance(int[][] grid) {
    	if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        // set n, m, grid
        setGrid(grid);
        
        List<Pair> houses = getPairsforType(HOUSE);
        // we could also integrate these two arrays to objects
        int[][] distanceSum = new int[n][m];
        int[][] visitedTimes = new int[n][m];
        for (Pair house : houses) {
            BFSMarking(house, distanceSum, visitedTimes);
        }
        
        int shortest = Integer.MAX_VALUE;
        List<Pair> empties = getPairsforType(EMPTY);
        for (Pair empty : empties) {
            if (visitedTimes[empty.x][empty.y] != houses.size()) {
                continue;
            }
            
            shortest = Math.min(shortest, distanceSum[empty.x][empty.y]);
        }
        
        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }
}
