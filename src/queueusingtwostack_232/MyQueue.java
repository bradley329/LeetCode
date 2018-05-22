package queueusingtwostack_232;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
       // do initialization if necessary
    	stack1 = new Stack<>();
    	stack2 = new Stack<>();
    }
    
    public void push(int element) {
        // write your code here
    	stack1.push(element);
    }

    public int pop() {
        // write your code here
    	if (stack2.empty()) {
			//push elements in stack1 to stack2;
    		while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}
    	return stack2.pop();
    }

    public int peek() {
        // write your code here
    	if (stack2.empty()) {
			//push elements in stack1 to stack2;
    		while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}
    	return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
