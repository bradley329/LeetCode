package graphvalidtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
// pure BFS detecting cross and back edges
// we dont predicate the number edges 
public class BFS {
	public boolean validTree(int n, int[][] edges) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0; i<n; i++){
		    ArrayList<Integer> adjlist = new ArrayList<Integer>();
		    map.put(i, adjlist);
		}

		for(int[] edge: edges){
		    map.get(edge[0]).add(edge[1]);
		    map.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		//how to predicate back edge or cross edge?
		while(!queue.isEmpty()){
		    int top = queue.poll();
		    if(visited[top])
		        return false;

		    visited[top]=true;

		    for(int i: map.get(top)){
		        if(!visited[i])
		            queue.offer(i);
		    }
		}

		for(boolean b: visited){
		    if(!b)
		        return false;
		}

		return true;
	}
}
