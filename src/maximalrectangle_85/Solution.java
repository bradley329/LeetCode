package maximalrectangle_85;

import java.util.Arrays;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        int res = 0;
        Arrays.fill(right, n);
        //Arrays.fill(height, 0);
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    cur_left = j + 1;
                    left[j] = 0;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    cur_right = j;
                    right[j] = n;
                }
            }
            for (int j = 0; j < n; j++) {
                res = Math.max(res, (right[j] - left[j])*height[j]);
            }
        }
        return res; 
    }
}
