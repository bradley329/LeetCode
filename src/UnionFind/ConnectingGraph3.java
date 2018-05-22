package UnionFind;
// query the count of connected components
// similar to island
public class ConnectingGraph3 {
	int[] father;
	int count;
    public ConnectingGraph3(int n) {
        // initialize your data structure here.
    	father = new int[1+n]; // since the lables are 1-n;
    	count = n;
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
			count--;
		}
    }
    
    public void connect(int a, int b) {
        // Write your code here
    	union(a, b);
    }
        
    public int query( ) {
        // Write your code here
    	return count;
    }
}
