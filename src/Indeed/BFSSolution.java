package Indeed;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Tuple implements Comparable<Tuple> {
	public int x;
	public int y;
	public int val;
	
	public Tuple(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public int compareTo(Tuple o) {
		return o.val - this.val;
	}	
}
public class BFSSolution {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // how many grids are there?
        for (int i = 0; i < N; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int numDots = scan.nextInt();
//			System.out.println("H: " + n);
//		    System.out.println("W: " + m);
//		    System.out.println("numDots: " + numDots);
		    Queue<Tuple> inks = new PriorityQueue<>();
		    for (int j = 0; j < numDots; j++) {
				int row = scan.nextInt();
				int col = scan.nextInt();
				int val = scan.nextInt();
				Tuple tp = new Tuple(row, col, val);
				//System.out.println("ink: " + tp.x+" "+tp.y+" "+tp.val);
				inks.offer(tp);
			}
		    //
		    BFSInking(n, m, inks);
		}      
    }
	
	private static boolean isValid (Tuple adj, int[][] grid) {
		int n = grid.length;
        int m = grid[0].length;
        
        return adj.x >= 0 && adj.x < n && 
        		adj.y >= 0 && adj.y < m && 
        		grid[adj.x][adj.y] < adj.val;
	}
	
	private static void BFSInking(int n, int m, Queue<Tuple> inks) {
		int[] deltaX = {0,1,-1,0};
		int[] deltaY = {1,0,0,-1};
		int[][] grid = new int[n][m];
		Queue<Tuple> runQue = new LinkedList<>();
		while (!inks.isEmpty()) {
			Tuple ink = inks.poll();
			if (grid[ink.x][ink.y] >= ink.val) {
				continue;
			}
			//start BFS:
			grid[ink.x][ink.y] = ink.val;
			runQue.offer(ink);
			while (!runQue.isEmpty()) {
				Tuple cur = runQue.poll();
				for (int i=0; i<4; i++) {
					Tuple adj = new Tuple(
							cur.x + deltaX[i], cur.y + deltaY[i], cur.val -1
							);
					if (!isValid(adj, grid)) {
						continue;
					}
					grid[adj.x][adj.y] = adj.val;
					runQue.offer(adj);
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum += grid[i][j];
			}
		}
		System.out.println(sum);
	}
}
