package CourseraOA;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayReduce {
	public int reduceSum(int[] nums) {
		int sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		pq.addAll(list);
	    while (pq.size() > 1) {
	    	int first = pq.poll();
	        int second = pq.poll();
	        sum += first + second;
	        pq.offer(first + second);
	    }
	        
	    return sum;
	}  
}
