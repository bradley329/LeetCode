package UnionFind;
import java.util.ArrayList;
import java.util.List;

public class friends {  
	private static class UnionFind {
		private int[] father;
		private int[] size;
	    public UnionFind(int n) {
	    	father = new int[1+n]; 
	    	size = new int[1+n];
	    	for (int i = 1; i <= n; i++) {
				father[i] = i;
				size[i] = 1;
			}    	
	    }
	    
	    private int find(int a) {
	    	if (father[a] == a) {
				return a;
			}
	    	return father[a] = find(father[a]);
	    }
	    
	    public void connect(int a, int b) {
	    	int root_a = find(a);
	    	int root_b = find(b);
	    	if (root_a != root_b) {
				father[root_a] = root_b;
				size[root_b] = size[root_a] + size[root_b];
			}
	    	
	    }
	        
	    public int query(int a, int b) {
	        // query the connected component's size
	    	int root_a = find(a);  
	    	int root_b = find(b);
	    	if (root_a != root_b) {
	    		return size[root_a] + size[root_b];
			}
	    	return size[root_a];
	    }
	}
	
    static int[] getGroups(int n, String[] queryType, int[] students1, int[] students2) {
    	UnionFind uf = new UnionFind(n);
    	List<Integer> tmp = new ArrayList<>();
    	for (int i = 0; i < queryType.length; i++) {
    		int student1 = students1[i];
    		int student2 = students2[i];
			if (queryType[i].equals("Friend")) {
				uf.connect(student1, student2);
			} else {
				tmp.add(uf.query(student1, student2));
			}
		}
    	int[] res = new int[tmp.size()];
    	for (int i = 0; i < tmp.size(); i++) {
			res[i] = tmp.get(i);
			int p = 461012;
			System.out.format("The value of p is: %d", p);
		}
    	return res;
    }    
}
