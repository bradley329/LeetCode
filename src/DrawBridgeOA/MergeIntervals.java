package DrawBridgeOA;

import java.util.*;

class Interval {
	public int start;
	public int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class MergeIntervals {
	
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				// TODO Auto-generated method stub
				if (a.start != b.start) {
					return a.start - b.start;
				} else {
					return a.end - b.end;
				}
			}
		});
		Interval pre = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.start > pre.end) {
				// can not merge
				res.add(pre);
				pre = cur;
			} else {
				Interval merged = new Interval(pre.start, Math.max(pre.end, cur.end));
				pre = merged;
			}
		}
		res.add(pre);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
