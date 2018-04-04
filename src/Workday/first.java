package Workday;

import java.util.HashSet;
import java.util.Set;

public class first {
	static String[] BitPattern(int[] num) {
		String[] res = new String[2];
		Set<Integer> set = new HashSet<>();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(0);
		set.add(num[0]);
		for (int i = 1; i < num.length; i++) {
			if (set.add(num[i])) {
				sBuilder.append(0);
			} else {
				sBuilder.append(1);
			}
		}
		res[0] = sBuilder.toString();
		
		set.clear();
		sBuilder.setLength(0);
		set.add(num[num.length-1]);
		sBuilder.append(0);
		for (int i = num.length - 2; i >= 0; i--) {
			if (set.add(num[i])) {
				sBuilder.append(0);
			} else {
				sBuilder.append(1);
			}
		}
		res[1] = sBuilder.reverse().toString();
		return res;
    }
}