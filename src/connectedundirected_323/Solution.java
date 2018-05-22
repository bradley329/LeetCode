package connectedundirected_323;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}

class UnionFind {
	HashMap<Integer, Integer> father;
	HashSet<Integer> copy;
    public UnionFind(HashSet<Integer> set) {
        // initialize your data structure here.
    	copy = new HashSet<>(set);
    	father = new HashMap<>(); // since the lables are 1-n;
    	for (int i : set) {
			father.put(i, i);
		}    	
    }
    
    int find(int a) {
    	if (father.get(a) == a) {
			return a;
		}
    	int rec = find(father.get(a));
    	father.put(a, rec);
    	return rec;
    }
    
    void union(int a, int b) {
    	int root_a = find(a);
    	int root_b = find(b);
    	if (root_a != root_b) {
			father.put(root_a, root_b);
		}
    }

    public List<List<Integer>> report() {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	HashMap<Integer, List<Integer>> map = new HashMap<>();
    	for(int i : copy) {
    		int root = this.find(i);
    		if(!map.containsKey(root)) {
    			map.put(root, new ArrayList<Integer>());
        }
        List<Integer> connect_component = map.get(root);
        connect_component.add(i);
        //map.put(root, connect_component);
    	}
    	for(List<Integer> connect_component : map.values()) {
    		Collections.sort(connect_component);
    		ans.add(connect_component);
    	}
        return ans;
    }
}

public class Solution {
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes){
		// Write your code here
		// since the label is unique
		HashSet<Integer> set = new HashSet<Integer>();
		// dont care about the relationships among the nodes, 
		// only add all the nodes to our set
	    for (UndirectedGraphNode cur : nodes) {
	    	set.add(cur.label);
	    	for(UndirectedGraphNode neighbour : cur.neighbors) {
	    		set.add(neighbour.label);
	    	}
	    }
	    
	    UnionFind uf = new UnionFind(set);
  
	    for(UndirectedGraphNode cur : nodes) {	      
	    	for(UndirectedGraphNode neighbour : cur.neighbors) {
	    		int fnow = uf.find(cur.label);
	    		int fneighbour = uf.find(neighbour.label);
	    		if(fnow != fneighbour) {
	    			uf.union(cur.label, neighbour.label);
	    		}
	    	}
	    }
	    return uf.report();    
	}
}
