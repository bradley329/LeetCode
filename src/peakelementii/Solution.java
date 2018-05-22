package peakelementii;

import java.util.ArrayList;
import java.util.List;

//��һά���Ǹ����� �������������СС���ڲ㣬���ڲ�˳��֪��
public class Solution {
	public List<Integer> findPeakII(int[][] A) {
		//û�п��Ǻ�ƫ�ı߽�����
        // write your code here
		int low = 1;
		int high = A.length - 2;
		//��Ϊ����֪������Ȧ��С���ǲ�����peak��
		//����while������<����ʲôҩ�������������mid��ôд
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
	//�ҵ�������������һ�С�
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
