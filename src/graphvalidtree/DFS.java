package graphvalidtree;

import java.util.ArrayList;
import java.util.HashMap;

//This problem can be converted to finding a cycle in a graph. 
//It can be solved by using DFS (Recursion) or BFS (Queue).
//note since when we DFS the graph, we could only start at one node
//when we build the adjacency list, we still should preserve the bidirectional edges.
public class DFS {
	public boolean validTree(int n, int[][] edges) {
	    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	    // adjacency lists
	    for(int i=0; i<n; i++){
	        ArrayList<Integer> adjlist = new ArrayList<Integer>();
	        map.put(i, adjlist);
	    }
	    // add neighbors to adj list;
	    for(int[] edge: edges){
	        map.get(edge[0]).add(edge[1]);
	        map.get(edge[1]).add(edge[0]);
	    }
	 
	    boolean[] visited = new boolean[n];
	 
	    //Note this Pre!!!
	    if(!helper(0, -1, map, visited))
	        return false;
	    // what if not connected and doesn't have cycle?
	    // if not connected the above will exit after on connected component has been DFSed
	    // so the later predication will be false:
	    for(boolean b: visited){
	        if(!b)
	            return false;
	    }
	 
	    return true;
	}
	// find the cycle 
	// the cycle must be a true cycle, that is 1->0 and then 0->1 is not!!!
	// that's why we need a pre!
	public boolean helper(int curr, int pre, HashMap<Integer, ArrayList<Integer>> map, boolean[] visited){
	    if(visited[curr])
	        return false;
	 
	    visited[curr] = true;
	    // typical DFS:
	    for(int i: map.get(curr)){
	        if(i!=pre && !helper(i, curr, map, visited)){
	            return false;
	        }
	    }   	 
	    return true;
	}
}
