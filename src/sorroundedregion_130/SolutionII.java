package sorroundedregion_130;

//其实都是一样的。把boundary置成不一样的来identify
//这个不同在于 他发现除了跟boundary有联系的所有o 其实都应该直接置成X
//中间的被包围的怎么connected 不关心
public class SolutionII {
	public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;

        int m = board.length;
        int n = board[0].length;

        //only traverse through the boundaries
        for(int i = 0; i < m; i ++){
            if(board[i][0] == 'O')
                dfs(board, i, 0);
            if(board[i][n - 1] == 'O')
                dfs(board, i, n - 1);
        }

        //one more traversal through the edges
        for(int j = 0; j < n ; j++){
            if(board[0][j] == 'O')
                dfs(board, 0, j);
            if(board[m - 1][j] == 'O')
                dfs(board, m-1, j);
        }

        //traverse the whole graph
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }

    }

    public void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;

        if(board[i][j] == 'O')
            board[i][j] = '*';

        if(i < board.length - 2 && board[i + 1][j] == 'O')
            dfs(board, i + 1, j);
        if(j < board[0].length - 2 && board[i][j + 1]== 'O')
            dfs(board, i, j+ 1);
        if(i > 1 && board[i-1][j] == 'O')
            dfs(board, i - 1, j);
        if(j > 1 && board[i][j-1] == 'O')
            dfs(board, i , j -1);
    }
}
