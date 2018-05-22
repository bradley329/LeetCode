
import java.util.*;

public class BaseBallGame {
	public int calPoints(String[] ops) {
		if (ops == null || ops.length == 0) {
			return 0;
		}
        Stack<Integer> stack = new Stack<>(); // in stack, all scores are valid
        int res = 0;
        int score = 0;
        for (String op : ops) {
        	if (op.length() == 1 && op.equals("C")) {
        		score = stack.pop();
			} else if (op.length() == 1 && op.equals("D")) {
				score = stack.peek() * 2;
				stack.push(score);	
			} else if (op.length() == 1 && op.equals("+")) {
				int tp1 = stack.pop();
				int tp2 = stack.peek();
				score = tp1 + tp2;
				stack.push(tp1);
				stack.push(score);	
			} else {
				score = Integer.parseInt(op);
				stack.push(score);
			}
        }
        
        if (!stack.isEmpty()) {
        	for (int num : stack) {
    			res += num;
    		}
		}
        return res;
    }
}
