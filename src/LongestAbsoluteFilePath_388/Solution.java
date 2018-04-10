package LongestAbsoluteFilePath_388;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int lengthLongestPath(String input) {
    Deque<Integer> stack = new ArrayDeque<>();
    String[] dirs = input.split("\n");
    int result = 0;
    stack.push(0); // similar to dummy node.
    // note that we assume root is level 1 instead of 0!
    for (String dir : dirs) {
      int level = dir.lastIndexOf("\t") + 1 + 1;
      while (stack.size() > level) {
        stack.pop();
      }
      int len = dir.length() - level + 1;
      if (dir.contains(".")) {
        result = Math.max(result, stack.peek() + len);
      } else {
        // stack stores the prefix sum!
        stack.push(stack.peek() + len + 1);
      }
    }
    return result;
  }
}
