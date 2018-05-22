package largestrecthist_84;

import java.util.Stack;

//����ǵ���ջ��� ����͵ģ�
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
	            //һ����������߶ȶϵ��ˣ�cur <= height[stack.peek()]
	            while (!stack.isEmpty() && cur <= height[stack.peek()]) {
	                int h = height[stack.pop()];
	                //������һ�к���Ҫ��
	                //���� 2 1 2����ȷ��Ӧ����1*3
	                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
	                max = Math.max(max, h * w);
	            }
	            stack.push(i);
	        }       
	        return max;
    }
}
