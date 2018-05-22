package MinStack_155;

import java.util.Stack;
//this solution uses two stacks
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.empty() == true)
            minStack.push(number);
        else {
        	// 这里考虑的相等的情况也会继续push.一定要！
        	// 好处是如果min值没变就不会重复push进minstack
        	if (minStack.peek() >= number)
        		minStack.push(number);
        	}
    }

    public int pop() {
        if (stack.peek().equals(minStack.peek()) ) 
            minStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
