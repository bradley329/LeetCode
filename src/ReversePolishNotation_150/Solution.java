package ReversePolishNotation_150;

import java.util.Stack;

public class Solution {
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0)
      return 0;
    if (tokens.length == 1)
      return Integer.parseInt(tokens[0]);
    if (tokens.length == 2) {
      switch (tokens[1]) {
        case "+":
          return Integer.parseInt(tokens[0]);

        case "-":
          return -Integer.parseInt(tokens[0]);

        default:
          return 0;
      }
    }

    // note: did not consider the corner case: ["1", "+", "3", "*"].
    Stack<Integer> operands = new Stack<>();
    int a = 0;
    int b = 0;
    for (String s : tokens) {
      switch (s) {
        case "+":
          // we assume operands have at least two numbers!
          operands.push(operands.pop() + operands.pop());
          break;
        case "-":
          a = operands.pop();
          b = operands.pop();
          operands.push(b - a);
          break;
        case "*":
          operands.push(operands.pop() * operands.pop());
          break;
        case "/":
          a = operands.pop();
          b = operands.pop();
          operands.push(b / a);
          break;
        default:
          operands.push(Integer.parseInt(s));
      }
    }
    return operands.pop();
  }
}
