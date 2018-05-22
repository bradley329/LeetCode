package searchgraphnode;

import java.util.*;

// a typical application of BFS!
// shortest path to a destination
public class Solution {
	public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
            Map<UndirectedGraphNode, Integer> values,
            UndirectedGraphNode node,
            int target) {
		if (node == null) {
			return null;
		}
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Set<UndirectedGraphNode> inQue = new HashSet<>(); 
		// note here inQue simply keep track of which nodes have already
		// been considered for processing.
		// it's not like visited where we only set to be true when "processed"!
		queue.offer(node);
		inQue.add(node);
		while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            if (values.get(cur) == target) {
                return cur;
            }
            
            for (UndirectedGraphNode nei : cur.neighbors) {
                if (!inQue.contains(nei)){
                    queue.offer(nei);
                    inQue.add(nei);
                }
            }		
		}
		return null;
	}
}
