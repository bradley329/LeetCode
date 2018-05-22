package Audible;

import java.util.Stack;

public class OA2 {
	public static String[] prefixToPostfix(String[] prefixes)
    {
		int n = prefixes.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
        	res[i] = prePostEval(prefixes[i]);
        }
        return res;
    }

	private static String prePostEval(String prefix) {
		if (prefix == null || prefix.length() <= 1) {
			return prefix;
		}
		int len =  prefix.length();
		char[] chArr = prefix.toCharArray();
		Stack<String> stack = new Stack<>();
		for (int i = len-1; i >= 0; i--) {
			char ch = chArr[i];
			if (ch == '+' || ch == '-' || ch == '*' || ch =='/') {
				String operand1 = stack.pop();
				String operand2 = stack.pop();
				stack.push(operand1 + operand2 + ch);
			} else {
				stack.push(String.valueOf(ch));
			}
		}
		return stack.pop(); // should only have one element in stack!
	}
	
    /* Driver program to test above function */
    public static void main(String[] args) 
    {
    	
    }
}
