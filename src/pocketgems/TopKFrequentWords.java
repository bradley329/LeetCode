package pocketgems;

import java.util.*;

class Pair implements Comparable<Pair> {
	public String s;
	public int ct;
	public Pair(String s, int ct) {
		// TODO Auto-generated constructor stub
		this.s = s;
		this.ct = ct;
	}
	
	//Note: we need a max heap:
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		if (this.ct == o.ct) {
			return this.s.compareTo(o.s);
		}
		return o.ct - this.ct;
	}
}
public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
        	map.put(word, map.getOrDefault(word, 0)+1);
        }
        Queue<Pair> que = new PriorityQueue<>();
        for (String word : map.keySet()) {
        	que.offer(new Pair(word, map.get(word)));
        }
        
        for (int i = 0; i < k; i++) {
			res.add(que.poll().s);
		}
        return res;
    }
}
