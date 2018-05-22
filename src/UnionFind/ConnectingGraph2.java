package UnionFind;
// query the count of nodes in the connected component which has "a"
public class ConnectingGraph2 {
	int[] father;
	int[] size;
    public ConnectingGraph2(int n) {
        // initialize your data structure here.
    	father = new int[1+n]; // since the lables are 1-n;
    	size = new int[1+n];
    	for (int i = 1; i <= n; i++) {
			father[i] = i;
			size[i] = 1;
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
			size[root_a] += size[root_b];
		}
    }
    
    public void connect(int a, int b) {
        // Write your code here
    	union(a, b);
    }
        
    public int query(int a) {
        // Write your code here
    	int root_a = find(a);
    	return size[root_a];
    }
}
