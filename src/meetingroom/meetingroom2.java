package meetingroom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class meetingroom2 {
	//就以时间顺序 按事件来看
	public int minMeetingRooms(Interval[] intervals) {
	    if(intervals==null||intervals.length==0)
	        return 0;	 
	    
	    Arrays.sort(intervals, new Comparator<Interval>() {
	    	@Override
	        public int compare(Interval o1, Interval o2) {
	            return o1.start - o2.start;
	        }
	    });
	 
	    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	    int count=1;
	    queue.offer(intervals[0].end);
	 
	    for (int i=1; i<intervals.length; i++) {
	    	//我要安排会议，最早能空出来的都不行，那必须++
	        if (intervals[i].start<queue.peek()) {
	            count++;	 
	        } else {
	            queue.poll();
	        }
	 
	        queue.offer(intervals[i].end);
	    }
	 
	    return count; // or return queue.size()
	}
}
