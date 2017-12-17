package ReshapetheMatrix_566;

public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) return nums;
        int rowNum = nums.length;
        int colNum = nums[0].length;
        if (rowNum * colNum != r * c || (rowNum == r && colNum == c)) return nums;
        int[][] res = new int[r][c];
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                int idx = row * colNum + col;
                int newRow = idx / c;
                int newCol = idx % c;
                res[newRow][newCol] = nums[row][col];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {{1,2,3},{4,5,6}};
        Solution ss = new Solution();
        int[][] res = ss.matrixReshape(input,3,2);
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[0].length; col++) {
                System.out.print(res[row][col]);
            }
            System.out.println();
        }
    }
}
