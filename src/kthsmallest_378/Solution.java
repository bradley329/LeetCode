package kthsmallest_378;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
	int x, y, value;
	
	public Point(int x, int y, int value) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return this.value - o.value;
	}
	
}
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
    	int m = matrix.length; // num of rows
    	int n = matrix[0].length; //num of columns
    	PriorityQueue<Point> pq = new PriorityQueue<>();
    	for(int i=0; i<n; i++) {
    		pq.offer(new Point(0, i, matrix[0][i]));
    	}
    	// since k is always valid, so we dont have to worry that pq may be empty
    	for(int j=0; j<k-1; j++) {
            Point t = pq.poll();
            if(t.x==m-1) continue;
            pq.offer(new Point(t.x+1, t.y, matrix[t.x+1][t.y])); //point in the next column
        }
        return pq.poll().value;
    }
}
