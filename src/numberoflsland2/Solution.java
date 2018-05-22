package numberoflsland2;

import java.util.ArrayList;
import java.util.List;

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

class UnionFind {
	private int father[];
	public UnionFind(int num) {
        // initialize your data structure here.
    	father = new int[num]; 
    	for (int i = 0; i < num; i++) {
			father[i] = i;
		}    	
    }
	
    int find(int a) {
    	if (father[a] == a) {
			return a;
		}
    	return father[a] = find(father[a]);
    }
    
    void union(int a, int b) {
    	int root_a = find(a);
    	int root_b = find(b);
    	if (root_a != root_b) {
			father[root_a] = root_b;
		}
    }
}

public class Solution {
	/**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
    	List<Integer> ans = new ArrayList<Integer>();
    	if (operators == null) {
			return ans;
		}
    	UnionFind uf = new UnionFind(n * m);
    	//后面居然是卡主的，因为自己觉得uf里已经有了谁和谁相连的信息就觉得不需要再建matrix了。
    	//但是uf是不知道是1还是0，他只管谁和谁是不是“连起来”。
    	int[][] matrix = new int[n][m];
    	int count = 0;
    	int []dx = {0,-1, 0, 1};
        int []dy = {1, 0, -1, 0};
    	for (int i = 0; i < operators.length; i++) {
			Point pt = operators[i];
			int x = pt.x;
			int y = pt.y;
			int index = x * m + y;
			if(matrix[x][y] != 1) {
				matrix[x][y]  = 1;
                count ++;
                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(0 <= nx && nx < n && 0 <= ny && ny < m && matrix[nx][ny] == 1) 
                    {
                        int nindex = nx * m + ny;                        
                        int fa = uf.find(index);
                        int nfa = uf.find(nindex);
                        if(fa != nfa) {
                            count--;
                            uf.union(index, nindex);
                        }
                    }
                }
            }
            ans.add(count);			
		}
    	return ans;
    }
}
