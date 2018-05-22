package UnionFind;
// int value represents nodes
public class ConnectingGraph1 { 
	int[] father;
    public ConnectingGraph1(int n) {
        // initialize your data structure here.
    	father = new int[1+n]; // since the lables are 1-n;
    	for (int i = 1; i <= n; i++) {
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
    
    public void connect(int a, int b) {
        // Write your code here
    	union(a, b);
    }
        
    public boolean query(int a, int b) {
        // Write your code here
    	int root_a = find(a);
    	int root_b = find(b);
    	return root_a == root_b;
    }
}