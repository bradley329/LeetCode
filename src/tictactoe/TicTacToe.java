package tictactoe;

//注意，n个是不需要连续的，所以diaganal的情况才能直接以这个判断
public class TicTacToe {
	int[] rows;
    int[] cols;
    int diag;
    int rev_diag;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n=n;
        this.rows=new int[n];
        this.cols=new int[n];
        this.diag = 0;
        this.rev_diag = 0;
    }
 
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
    	
        int val = (player==1?1:-1);
 
        rows[row]+=val;
        cols[col]+=val;
 
        if(row==col){
            diag+=val;
        }
        if(col==n-row-1){
            rev_diag+=val;
        }
 
        if(Math.abs(rows[row]) == n 
        || Math.abs(cols[col]) == n 
        || Math.abs(diag) == n 
        || Math.abs(rev_diag) == n){
            return player;
        }
 
        return 0;
    }
}
