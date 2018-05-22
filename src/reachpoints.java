
public class reachpoints {
	private static boolean res;
	public static String canReach(int x1, int y1, int x2, int y2) {
		res = false;
		DFSHelper(x1, y1, x2, y2);
		return res ? "Yes" : "No";
	}
	
	private static void DFSHelper(int x1, int y1, int x2, int y2) {
		if (res || (x1 > x2 || y1 > y2)) {
			return;
		}
		if (x1 == x2 && y1 == y2) {
			res = true;
			return;
		}
		DFSHelper(x1+y1, y1, x2, y2);
		DFSHelper(x1, x1+y1, x2, y2);
	}
}
