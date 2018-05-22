package clonegraph_133;

import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class Solution {
	//ע�ⲻ����set����Ϊ��Ҫcopy������Ѿ�DFS������Ҳ�Ƿ���node��Ӧ���Ƿ�copy
	//������ֱ��return node����
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
