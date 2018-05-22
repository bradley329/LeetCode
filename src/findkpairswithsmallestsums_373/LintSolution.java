package findkpairswithsmallestsums_373;

import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
	public int x, y, val;
	public Pair(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
	
}

public class LintSolution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
    	int m = A.length; // num of rows
    	int n = B.length; //num of columns
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	for(int i=0; i<n; i++) {
    		pq.offer(new Pair(0, i, A[0]+B[i]));
    	}
    	// since k is always valid, so we dont have to worry that pq may be empty
    	for(int j=0; j<k-1; j++) {
            Pair t = pq.poll();
            if(t.x==m-1) continue;
            pq.offer(new Pair(t.x+1, t.y, A[t.x+1]+B[t.y])); //point in the next column
        }
        return pq.poll().val;
    }
}