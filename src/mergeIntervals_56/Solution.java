package mergeIntervals_56;

import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()<=1) return intervals;
		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		List<Interval> res = new ArrayList<Interval>(); 	
		int st = intervals.get(0).start, end = intervals.get(0).end;
		for (int i=1; i<intervals.size(); i++) {
			if (intervals.get(i).start <= end) {
				end = Math.max(end, intervals.get(i).end);
			} else {
				res.add(new Interval(st,end));				
				st = intervals.get(i).start;
				end = intervals.get(i).end;
			}				
		}
		res.add(new Interval(st,end));
		return res;   
    }
}
