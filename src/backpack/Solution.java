package backpack;

public class Solution {
	public int backPack(int m, int[] A) {
		/*
		if (A.length == 0) {
			return 0;
		}
		*/
		//dp数组f[i][j]是说在i前 能不能达到j的size
		//这个其实也不难想，因为你首先知道要知道subproblem的值去求最后的值
		//要想知道整体能取多少，就得知道前面几个能取多少，因为正好size有限制，所以j才有这样的含义
		boolean f[][] = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= A[i-1] && f[i-1][j - A[i-1]]) {
                    f[i][j] = true;
                }
            } // for j
        } // for i
        for (int i = m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }
        return 0;
	}
}
