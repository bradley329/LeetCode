package maximalsquare_221;
//很是neat，因为i=0 和 j=0的情况 也符合b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
public class Leetsolution {
	public int maximalSquare(char[][] a) {
	    if(a.length == 0) return 0;
	    int m = a.length, n = a[0].length, res = 0;
	    int[][] b = new int[m+1][n+1];
	    for (int i = 1 ; i <= m; i++) {
	        for (int j = 1; j <= n; j++) {
	            if(a[i-1][j-1] == '1') {
	                b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
	                res = Math.max(b[i][j], res); // update result
	            }
	        }
	    }
	    return res*res;
	}
}
