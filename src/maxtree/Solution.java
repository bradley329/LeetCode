package maxtree;

import java.util.Stack;

//����ջ�ĵ�����
//����8 6 4 5 7
//��5��ʱ��6 4 5һ�ȣ�֪����4Ϊ5�������飻
//Ȼ����8 657�� 657����5��6����������
//Ȼ����867��
//������ϸ��̫���ˣ�
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