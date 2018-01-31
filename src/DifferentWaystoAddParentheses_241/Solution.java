package DifferentWaystoAddParentheses_241;

import java.util.*;

//之所以叫divide conquer是因为对每一个subproblem，都只分了0-i和(i+1) - end
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
    	List<Integer> res = new ArrayList<>();
    	for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
    		if (c == '+' || c == '-' || c == '*') {
				List<Integer> leftPart = diffWaysToCompute(input.substring(0, i));
				List<Integer> rightPart = diffWaysToCompute(input.substring(i+1));
				// different combinations of left and right;
				for (int j = 0; j < leftPart.size(); j++) {
					int left = leftPart.get(j);
					for (int k = 0; k < rightPart.size(); k++) {
						int right = rightPart.get(k);
						int tp = 0;
						if (c == '+') {
							tp = left + right;
						} else if (c == '-') {
							tp = left - right;
						} else {
							tp = left * right;
						}
						res.add(tp);
					}
				}
			}
		}
    	// base case: if only number?
    	if (res.isEmpty()) {
			res.add(Integer.parseInt(input));
		}
        return res;
    }
}
