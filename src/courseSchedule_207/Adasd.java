package courseSchedule_207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class courses{
    int id;
    List<Integer> nextCourse;
    boolean ifroot;
    public courses(int id){
        this.id = id;
        this.nextCourse = new ArrayList<>();
        ifroot = true;
    }
}
public class Adasd {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        courses[] course = new courses[numCourses];
        Queue<courses> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < prerequisites.length; i++){
            int next = prerequisites[i][0];
            int id = prerequisites[i][1];
            if (course[id] == null){
                course[id] = new courses(id);
            }
            if (course[next] == null){
                course[next] = new courses(next);               
            }
            course[next].ifroot = false;
            indegree[next]++;
            course[id].nextCourse.add(next);
        }
        for (int i = 0; i < course.length; i++){
            if (course[i] != null && course[i].ifroot){
                q.offer(course[i]);
            }
            if (course[i] == null) {
                count++;
            }
        }
        while (!q.isEmpty()){
            courses c = q.poll();
            count++;
            for (int i : c.nextCourse){
                indegree[i]--;
                if (indegree[i] == 0){
                    q.offer(course[i]);
                }
            }
        }
        System.out.println(count);
        return count == numCourses;
    }
}
