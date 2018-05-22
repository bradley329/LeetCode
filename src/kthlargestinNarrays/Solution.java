package kthlargestinNarrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Entry implements Comparable<Entry> {

	public int from, index, val;
	public Entry(int from, int index, int val) {
		// TODO Auto-generated constructor stub
		this.from = from;
		this.index = index;
		this.val = val;
	}
	@Override
	public int compareTo(Entry o) {
		// TODO Auto-generated method stub
		return o.val - this.val;
	}
	
}
public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
    	//sort N arrays
    	int n = arrays.length;
    	Queue<Entry> pq = new PriorityQueue<>(k);
    	for (int i = 0; i < n; i++) {
			Arrays.sort(arrays[i]);
			if(arrays[i].length > 0) {
				Entry et = new Entry(i, arrays[i].length-1, arrays[i][arrays[i].length-1]);
				pq.offer(et);
			}
		}
    	for (int j = 0; j < k-1; j++) {
			Entry tp = pq.poll();
			int from = tp.from;
			int index = tp.index;
			if (index > 0) {
				index--;
				int val = arrays[from][index];
				Entry entry = new Entry(from, index, val);
				pq.offer(entry);
			}
		}
    	return pq.poll().val;
    }
}