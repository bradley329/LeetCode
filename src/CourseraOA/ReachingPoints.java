package CourseraOA;

public class ReachingPoints {
	public boolean dfs(int x1, int y1, int x2, int y2) {
		if (x1 == x2 && y1 == y2) {
			return true;
		} else if (x1 > x2 || y1 > y2) {
			return false;
		}	
		return dfs(x1+y1, y1, x2, y2) || dfs(x1, y1+x1, x2, y2);
	}
}
