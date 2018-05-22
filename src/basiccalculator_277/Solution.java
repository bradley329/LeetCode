package basiccalculator_277;

import java.util.Stack;

public class Solution {
	public int calculate(String s) {
		int res = 0, num = 0;
        char op = '+';
        //op是指当前数字和栈顶元素的关系.
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0') {
            	num = num * 10 + s.charAt(i) - '0';
            }
            if ((s.charAt(i) < '0' && s.charAt(i) != ' ') || i == s.length() - 1) {
                if (op == '+') nums.push(num);
                if (op == '-') nums.push(-num);
                if (op == '*' || op == '/') {
                    int tmp = op == '*' ? nums.pop() * num : nums.pop() / num;
                    nums.push(tmp);
                }
                op = s.charAt(i);
                num = 0;
            } 
        }
        while (!nums.isEmpty()) {
            res += nums.pop();
        }
        return res;
	}
}
