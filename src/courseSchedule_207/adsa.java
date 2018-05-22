package courseSchedule_207;

import java.util.ArrayList;
import java.util.List;

class courses{
    int id;
    List<Integer> nextCourse;
    boolean ifroot;
    boolean visited;
    boolean finish;
    public courses(int id){
        this.id = id;
        this.nextCourse = new ArrayList<Integer>();
        this.visited = false;
        this.finish = false;
        this.ifroot = true;
    }
}
public class adsa {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        courses[] course = new courses[numCourses];
        for (int i = 0; i < numCourses; i++){
            int id = prerequisites[i][0];
            int next = prerequisites[i][1];
            if (course[id] == null){
                course[id] = new courses(id);
            }
            if (course[next] == null){
                course[next] = new courses(next);
                course[next].ifroot = false;
            }
            course[id].nextCourse.add(next);
        }
        for (int i = 0; i < course.length; i++){
            if (course[i] != null && course[i].ifroot == true){
                if (!helper(course, i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(courses[] course, int i) {
        if (course[i].visited == true && course[i].finish == false){
            return false;
        }
        course[i].visited = true;
        for (int next : course[i].nextCourse){
            if (!helper(course, next)){
                return false;
            }
        }
        course[i].finish = true;
        return true;
    }
}
