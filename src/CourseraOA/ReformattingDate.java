package CourseraOA;

import java.util.HashMap;
import java.util.Map;

public class ReformattingDate {
	public String helper(String s) {
		Map<String, String> month = new HashMap<>();
		Map<String, String> day = new HashMap<>();
		String[] res = s.split(" ");
		String ans= res[2] + '-' + month.get(res[1]) + '-' + day.get(res[0]);
		return ans;
	}
}
