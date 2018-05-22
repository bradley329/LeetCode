package maximalrectangle_85;

import java.util.Stack;
//������Ǹ�DP�Ǹ�һ������heightΪ׼��ɨ��!
//�������ڣ��ҿ����벻��ɨ�У���Ϊ��ñϾ��������
//����ջ��������ָ
public class SolutionusingStack {
	public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = (m == 0 ? 0 : matrix[0].length);
        int[][] height = new int[m][n + 1];//ע�⣡һ����n+1��Ϊ���������n������0��
 
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (! matrix[i][j]) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = (i == 0 ? 1 : height[i - 1][j] + 1);
                    //��heightΪ��׼���Ϳ�height���Ͽ��ܶ��
                }
            }
        }
 
        for (int i = 0; i < m; i++) {
            int area = maxAreaInHist(height[i]);//��Ȼ��һ��һ�е�ɨ��
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
 
    private int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
    
        int i = 0;
        int max = 0;
        //ע��height��length��n+1;
        while (i < height.length) {
        	//����ջ֮���Ե�����
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                max = Math.max(max, height[t]
                        * (stack.isEmpty() ? i : i - t - 1));
                //�����ʵ��ľ����룡
                //��������ߵĸ߶����������죬���ˣ���ô���ڵ�i���ҽ磬��ȥ��缴stack.peek�������ǳ���
                //���У���Ϊջ�еĸ߶��ǵ�����������Ŷϵģ���ô���i��Ϊ�ұ߽��һֱ��Ϯ��ȥ��֪��stack.isEmpty!
            }
        }
        return max;
    }
}
