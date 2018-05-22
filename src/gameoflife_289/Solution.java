package gameoflife_289;
//状态0： 死细胞转为死细胞

//状态1： 活细胞转为活细胞

//状态2： 活细胞转为死细胞

//状态3： 死细胞转为活细胞
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] dx = new int[] {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		//注意 board[i][j]只会是0或1;
        		//因为他是第一次准备更新;
        		int count = 0;
        		int oldstate = board[i][j];
        		for(int k=0; k<8; k++) {
        			int x = i + dx[k];
        			int y = j + dy[k];
        			if(x>=0 && x<m && y>=0 && y<n) {
        				int state = board[x][y];
        				if(state == 1 || state == 2)
        				{
        					count++;
        				}
        			}
        		}
        		if(oldstate==1 && (count<2 || count>3)) {
        			board[i][j] = 2;
        		} 
        		else if(oldstate==0 && count==3) {
        			board[i][j] = 3;
        		}
        	}
        }
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		board[i][j] = board[i][j] % 2;
        	}
        }
    }
}
