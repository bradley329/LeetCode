package graphvalidtree;
//since the labels are 0 - n-1, so:
class UnionFind{
    int[] father;
    UnionFind(int n){
    	father = new int[n];
        for(int i = 0 ; i < n; i++) {
            father[i] = i; 
        }
    }
    int find(int x){
        int parent = father[x];
        if (parent == x) {
			return parent;
		}
        return father[x] = find(parent);    
    }
    
    void union(int x, int y){
        int fa_x = find(x);
        int fa_y = find(y);
        if(fa_x != fa_y) {
        	father[fa_x] = fa_y;
        }
    }
}

public class UnionFindSolution {
	public boolean validTree(int n, int[][] edges) {
        // tree should have n nodes with n-1 edges
        if (n - 1 != edges.length) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        // can not have back edge, cross edge. In this problem's setting
        // can not have a cycle.
        for (int i = 0; i < edges.length; i++) {
            if (uf.find(edges[i][0]) == uf.find(edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}
