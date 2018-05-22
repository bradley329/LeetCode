package graphvalidtree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
// this problem is not essentially equals to find cycle
// 1. connected but has cycle--- edges number do not equal to n-1
// 2. not connnected and does not have cycle--- edges number do not equal to n-1
// 3. not connnected and has cycle--- edges number equal to n-1 so have to further compute:
// since it is not connected so when hash.size()!=n means there are some nodes left
public class anotherBFS {
	public static boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
        	System.out.println("im print");
            return false;
        }
        System.out.println("im print");
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        
        // note: since we have first predicate when there are more edges permitted
        // so return (hash.size() == n) is strong enough!
        // if we dont predicate number of edges, the final return is not correct.
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        
        queue.offer(0);
        hash.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                if (hash.contains(neighbor)) {
                    continue;
                }
                hash.add(neighbor);
                System.out.println("im print: "+(neighbor));
                queue.offer(neighbor);
            }
        }
        
        return (hash.size() == n);
    }
    
    private static Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
    }

    public static void main(String[] args) {
    	int[][] edges = {{0, 1}, {0, 2}, {4, 3}, {5, 3}, {5, 4}}; 
    	validTree(6, edges);
    }
}
