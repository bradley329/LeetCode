package findkpairswithsmallestsums_373;

import java.util.ArrayList;
import java.util.List;
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

public class LeetSolution {
	/**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Write your code here
    	int m = nums1.length; // num of rows
    	int n = nums2.length; //num of columns
    	List<int[]> res = new ArrayList<>();
    	if (nums1==null||nums1.length==0||nums2==null||nums2.length==0) {
			return res;
		}
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	for(int i=0; i<n; i++) {
    		pq.offer(new Pair(0, i, nums1[0]+nums2[i]));
    	}
    	// since k might exceed n*m
    	for(int j=0; j<k; j++) {
    		if (pq.isEmpty()) {
				break;
			}
            Pair t = pq.poll();
            int[] pair = new int[2];
            pair[0] = nums1[t.x];
            pair[1] = nums2[t.y];
            res.add(pair);
            if(t.x>=m-1) continue;
            pq.offer(new Pair(t.x+1, t.y, nums1[t.x+1]+nums2[t.y])); //point in the next column
        }
        return res;
    }
}
