package backpack;

public class Solution {
	public int backPack(int m, int[] A) {
		/*
		if (A.length == 0) {
			return 0;
		}
		*/
		//dp����f[i][j]��˵��iǰ �ܲ��ܴﵽj��size
		//�����ʵҲ�����룬��Ϊ������֪��Ҫ֪��subproblem��ֵȥ������ֵ
		//Ҫ��֪��������ȡ���٣��͵�֪��ǰ�漸����ȡ���٣���Ϊ����size�����ƣ�����j���������ĺ���
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
