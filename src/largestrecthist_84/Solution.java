package largestrecthist_84;

import java.util.Stack;

//这个是单调栈最简单 最典型的！
public class Solution {
    public int largestRectangleArea(int[] height) {
        // write your code here
	    	if (height == null || height.length == 0) {
	            return 0;
	        }
	    	
	        Stack<Integer> stack = new Stack<Integer>();
	        int max = 0;
	        
	        for (int i = 0; i <= height.length; i++) {
	            int cur = (i == height.length) ? -1 : height[i];
	            //一旦发现这个高度断掉了：cur <= height[stack.peek()]
	            while (!stack.isEmpty() && cur <= height[stack.peek()]) {
	                int h = height[stack.pop()];
	                //下面这一行很重要，
	                //比如 2 1 2，正确答案应该是1*3
	                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
	                max = Math.max(max, h * w);
	            }
	            stack.push(i);
	        }       
	        return max;
    }
}
