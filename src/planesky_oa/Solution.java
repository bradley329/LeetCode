package planesky_oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//重点在于将事件抽象为point 并排序
class Interval {
	int start, end;//time
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class Point implements Comparable<Point> {
	public int time, flag;
	//if we suppose flag = 1 fly, flag = 0 landing;
	public Point(int time, int flag) {
		// TODO Auto-generated constructor stub
		this.time = time;
		this.flag = flag;
	}
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if (this.time == o.time) {
			return this.flag - o.flag;
		}
		return this.time - o.time;
	}
	
	
}
public class Solution {
	public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
		List<Point> list = new ArrayList<>(airplanes.size()*2);
		for (Interval i : airplanes) {
			list.add(new Point(i.start, 1));
			list.add(new Point(i.end, 0));
		}
		Collections.sort(list);
		
		int count = 0, ans = 0;		
		for(Point p : list){
			if(p.flag == 1) count++;
		    else count--;
		    ans = Math.max(ans, count);
		}
		return ans;
    }
}
