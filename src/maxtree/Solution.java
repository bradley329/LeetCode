package maxtree;

import java.util.Stack;

//单调栈的典型题
//比如8 6 4 5 7
//在5的时候，6 4 5一比，知道是4为5的左子书；
//然后是8 657。 657里是5是6的有字数；
//然后是867。
//问题是细节太多了！
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
    	Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = null;
        for (int i = 0; i <= A.length; i++) {
        	TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE)
              : new TreeNode(A[i]);
          while (!stack.isEmpty()) {
            if (right.val > stack.peek().val) {
              TreeNode nodeNow = stack.pop();
              if (stack.isEmpty()) {
                right.left = nodeNow;
              } else {
                TreeNode left = stack.peek();
                if (left.val > right.val) {
                  right.left = nodeNow;
                } else {
                  left.right = nodeNow;
                }
              }
            } else
              break;
          }
          stack.push(right);
        }
        return stack.peek().left;
      }
}