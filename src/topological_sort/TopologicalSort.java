package topological_sort;

import java.util.*;

// based on BFS and select each node by indegree == 0;
public class TopologicalSort {
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> indegreeMap = new HashMap<>();
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (indegreeMap.containsKey(neighbor)) {
                	indegreeMap.put(neighbor, indegreeMap.get(neighbor) + 1);
                } else {
                	indegreeMap.put(neighbor, 1); 
                }
            }
        }
        // only nodes who have at least one indegree in the map
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!indegreeMap.containsKey(node)) {
                q.offer(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            result.add(node);
            for (DirectedGraphNode n : node.neighbors) {
            	indegreeMap.put(n, indegreeMap.get(n) - 1);
                if (indegreeMap.get(n) == 0) {
                    q.offer(n);
                }
            }
        }
        return result;
    }
}
