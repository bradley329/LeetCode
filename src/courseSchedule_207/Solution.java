package courseSchedule_207;

import java.util.ArrayList;
import java.util.List;

//find circle in a directed graph
//习惯用DFS了，也可以BFS！
class Course1 {
	public List<Integer> child;
	public int val;
	public boolean incoming;
	public boolean visited;
	public boolean finished;
	public Course1(int val) {
		// TODO Auto-generated constructor stub
		this.child = new ArrayList<>();
		this.val = val;
		this.incoming = false;
		this.visited = false;
		this.finished = false;
	}
}

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        //first, build adjacency list
		if (prerequisites == null || prerequisites.length == 0) {
			return true;
		}
		Course1[] courses = new Course1[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int cur = prerequisites[i][1];
			int next = prerequisites[i][0];
			if (courses[cur] == null) {
				courses[cur] = new Course1(cur);
			}
			if (courses[next] == null) {
				courses[next] = new Course1(next);
				courses[next].incoming = true;
			}
			courses[cur].child.add(next);
		}

		for (int i = 0; i < courses.length; i++) {
			if (courses[i]!=null && !courses[i].incoming) {
				if(!DFS(i,courses)) return false;
			}
		}
		return true;
    }
	
	//这个时候就知道BFS好了！
	//怎么把visited的信息传到主函数？
	private boolean DFS(int cur, Course1[] courses) {
		//base case
		if (courses[cur].visited && !courses[cur].finished) {
			return false;
		}
		courses[cur].visited = true;
		for (int next : courses[cur].child) {
			if (!DFS(next, courses)) {
				return false;
			}
		}
		courses[cur].finished = true;
		return true;
	}
}
