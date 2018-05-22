package Intuit_Phone;

import java.util.*;

import meetingroom.Interval;

public class MergeInterval {
	public static List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> ans = new ArrayList<>();

        intervals.sort(Comparator.comparing(i -> i.start));  //lambda 匿名函数：输入i  返回i.start

        Interval last = null;
        int free = 0;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
            	if (last == null) {
					free += item.start;
				} else {
					free += item.start - last.end;
				}
                ans.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end); // Modify the element already in list
            }
        }
        System.out.println(free);
        return ans;
    }
}
