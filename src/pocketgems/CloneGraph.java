package pocketgems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class CloneGraph {
	//注意不能用set，因为是要copy，如果已经DFS过，那也是返回node对应的那份copy
	//而不是直接return node本身！
	//Set<Integer> visited = new HashSet<>();
	Map<Integer, UndirectedGraphNode> copyMap = new HashMap<>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		
		if (copyMap.containsKey(node.label)) {
			return copyMap.get(node.label);
		}
		
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		copyMap.put(node.label, copy);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			copy.neighbors.add(cloneGraph(neighbor));
		}
		return copy;
	}   
}

