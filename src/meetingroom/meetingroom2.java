package meetingroom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class meetingroom2 {
	//����ʱ��˳�� ���¼�����
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
	    	//��Ҫ���Ż��飬�����ܿճ����Ķ����У��Ǳ���++
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
