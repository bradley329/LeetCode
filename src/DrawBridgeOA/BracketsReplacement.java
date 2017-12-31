package DrawBridgeOA;

import java.util.*;

public class BracketsReplacement {
	public static boolean couldReplaceWithTimes(String s, int time) {
		if (s == null || s.length() < 1) {
			return false;
		}
		Deque<Character> stack = new ArrayDeque<>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '>') {
				if (time <= 0) {
					// no way to replace
					if (stack.isEmpty() || stack.pop() != '<') {
						return false;
					}
				} else {
					if (stack.isEmpty() || stack.pop() != '<') {
						time--;
					}
				}
			} else {
				stack.push(s.charAt(i));
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.print(couldReplaceWithTimes("<><><<>>>", 2));
	}
}
