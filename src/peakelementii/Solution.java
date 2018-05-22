package peakelementii;

import java.util.ArrayList;
import java.util.List;

//跟一维的那个很像 ，还是最外层最小小于内层，但内层顺序不知道
public class Solution {
	public List<Integer> findPeakII(int[][] A) {
		//没有考虑很偏的边界条件
        // write your code here
		int low = 1;
		int high = A.length - 2;
		//因为我们知道最外圈最小，是不可能peak的
		//具体while条件是<还是什么药具体分析，包括mid怎么写
		List<Integer> ans = new ArrayList<>();
		while (low <= high) {
			int midRow = (low + high)/2;
			int peakCol = findPeakCol(midRow, A);
			if (A[midRow][peakCol] < A[midRow - 1][peakCol]) {
				high = midRow - 1;
			} else if (A[midRow][peakCol] < A[midRow + 1][peakCol]) {
				low = midRow + 1;
			} else {
				ans.add(midRow);
				ans.add(peakCol);
				break;
			}
		}
		return ans;
    }
	//找的是这行最大的那一列。
	int findPeakCol(int row, int[][] A) {
		int col = 1;
		for(int i = 2; i < A[row].length; i++) {
            if(A[row][i] > A[row][col]) {
                col = i;
            }
        }
		return col;
	}
}
