package pocketgems;

import java.util.*;

public class TopKFrequentNumbers {
	class Pair implements Comparable<Pair> {
		int num, count;
		public Pair(int num, int count) {
			// TODO Auto-generated constructor stub
			this.num = num;
			this.count = count;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return o.count - this.count;
		}	
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
			return res;
		}
        
        HashMap<Integer, Integer> num_count = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for (int i : nums) {
			if (num_count.containsKey(i)) {
				num_count.put(i, num_count.get(i)+1);
			} else {
				num_count.put(i, 1);
			}
		}
        
        for (int num : num_count.keySet()) {
        	int count = num_count.get(num);
        	Pair pair = new Pair(num, count);
        	pq.offer(pair);
        }
        
        for (int i = 0; i < k; i++) {
			res.add(pq.poll().num);
		}
        
        return res;
    }
}
