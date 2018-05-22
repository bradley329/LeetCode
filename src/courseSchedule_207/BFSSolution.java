package courseSchedule_207;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Course {
	public List<Integer> child;
	public int val;
	public int indegree;
	//public boolean visited;
	//public boolean finished;
	public Course(int val) {
		// TODO Auto-generated constructor stub
		this.child = new ArrayList<>();
		this.val = val;
		this.indegree = 0;
		//this.visited = false;
		//this.finished = false;
	}
}

public class BFSSolution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0) {
			return true;
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
		
		int count = 0;
	    Queue<Integer> queue = new LinkedList<>();
	    for (int i=0; i<numCourses; i++) {
	    	if (courses[i] == null) count++;
	        if (courses[i] != null && courses[i].indegree == 0) queue.offer(i);
	    }
	    while (!queue.isEmpty()) {
	        int cur = queue.poll();
	        count++;
	        for (int next : courses[cur].child) {
	        	if (--courses[next].indegree == 0)
                    queue.offer(next);
	        }
	    }
	    return count == numCourses;
	}
}
