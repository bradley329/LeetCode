package sorroundedregion_130;

class Unionfind { 

    private int[] father;
    private int count;

    public Unionfind(int n) {
        // initialize your data structure here.
        father = new int[n];
        for (int i = 0; i < n; ++i) {
            father[i] = i;
        }
    }
    
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    
    boolean connected(int p, int q) {
		return find(p) == find(q);
	}
    
    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            count --;
        }
    }
        
    public int get_count() {
        // Write your code here
        return count;
    }
    
    public void set_count(int total) {
        count = total;
    }
}
public class Solution {
	public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) {
			return;
		}
        int m = board[0].length;
        Unionfind uf = new Unionfind(n*m+1); 
        //+1 since we have a dummy node which is used to
        //identify zeros connected to the border.
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if((i==0||i==n-1||j==0||j==m-1) && board[i][j]=='O') {
                	uf.connect(i*m+j,n*m);
                	// if a 'O' node is on the boundry, connect it to the dummy node   
                } else if (board[i][j]=='O') {
                    if(board[i-1][j]=='O')
                        uf.connect(i*m+j,(i-1)*m+j);
                    if(board[i+1][j]=='O')
                        uf.connect(i*m+j,(i+1)*m+j);
                    if(board[i][j-1]=='O')
                        uf.connect(i*m+j,i*m+j-1);
                    if(board[i][j+1]=='O')
                        uf.connect(i*m+j,i*m+j+1);
                }
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!uf.connected(i*m+j,n*m)) { 
                	// if a 'O' node is not connected to the dummy node, it is captured
                    board[i][j]='X';
                }
            }
        }
    }
}
