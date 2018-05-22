package maximalrectangle_85;

import java.util.Stack;
//这个还是跟DP那个一样，以height为准，扫行!
//问题在于，我可能想不到扫行，因为求得毕竟是面积！
//单调栈，单调是指
public class SolutionusingStack {
	public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = (m == 0 ? 0 : matrix[0].length);
        int[][] height = new int[m][n + 1];//注意！一定是n+1因为如果超出了n，就是0；
 
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (! matrix[i][j]) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = (i == 0 ? 1 : height[i - 1][j] + 1);
                    //以height为基准，就看height向上看能多高
                }
            }
        }
 
        for (int i = 0; i < m; i++) {
            int area = maxAreaInHist(height[i]);//依然是一行一行的扫；
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
        //注意height的length是n+1;
        while (i < height.length) {
        	//单调栈之所以单调：
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                max = Math.max(max, height[t]
                        * (stack.isEmpty() ? i : i - t - 1));
                //这个其实真的巨难想！
                //如果这个最高的高度他向宽度延伸，断了，那么现在的i是右界，减去左界即stack.peek，正好是长。
                //还有，因为栈中的高度是递增过来到这才断的，那么这个i作为右边界会一直沿袭下去，知道stack.isEmpty!
            }
        }
        return max;
    }
}
