package expressionexpand;

import java.util.Stack;
//不用stack 就得用递归了
public class usingstack {
	public String expressionExpand(String s) {
		//omg, Object
        Stack<Object> stack = new Stack<>();
        int number = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
                stack.push(Integer.valueOf(number));
                number = 0;
            } else if (c == '[') {
                stack.push(Integer.valueOf(number));
                number = 0; 
            } else if (c == ']') {
                String newStr = popStack(stack);
                Integer count = (Integer) stack.pop();
                for (int i = 0; i < count; i++) {
                    stack.push(newStr);
                    //这个以后总的newStr的顺序是反的，但是newStr内部是正的
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }
        
        return popStack(stack);//最后pop出来就顺序了
    }
    
    private String popStack(Stack<Object> stack) {
        // pop stack until get a number or empty
        Stack<String> buffer = new Stack<>();
        while (!stack.isEmpty() && (stack.peek() instanceof String)) {
            buffer.push((String) stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }
        return sb.toString();
    }
}
