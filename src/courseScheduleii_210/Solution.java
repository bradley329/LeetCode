package courseScheduleii_210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Course {
	public List<Integer> child;
	public int val;
	public int indegree;
	
	public Course(int val) {
		// TODO Auto-generated constructor stub
		this.child = new ArrayList<>();
		this.val = val;
		this.indegree = 0;
	}
}
//学乖了,直接用BFS做！
public class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) {
			return new int[0];
		}
		int[] res = new int[numCourses];
		if (prerequisites == null || prerequisites.length == 0) {
			for (int i=0; i<numCourses; i++) {
				res[i] = i;
			}
			return res;
		}		
		Course[] courses = new Course[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
	        int next = prerequisites[i][0];
	        int cur = prerequisites[i][1];
	        if (courses[cur] == null) {
				courses[cur] = new Course(cur);
			}
			if (courses[next] == null) {
				courses[next] = new Course(next);
			}
			courses[cur].child.add(next);
			courses[next].indegree++;
	    }
		int index = 0;
		int count = 0;
	    Queue<Integer> queue = new LinkedList<>();
	    for (int i=0; i<numCourses; i++) {
	    	if (courses[i] == null) {
	    		res[index] = i;
	    		index++;
	    		count++;
	    	}
	        if (courses[i] != null && courses[i].indegree == 0) {
	        	queue.offer(i);
	        }
	    }
	    
	    while (!queue.isEmpty()) {
	        int cur = queue.poll();
	        res[index] = cur;
        	index++;
	        count++;
	        for (int next : courses[cur].child) {
	        	if (--courses[next].indegree == 0) {	        		
	        		queue.offer(next);
	        	}                   
	        }
	    }
	    return count == numCourses ? res :new int[0];
	}
}
