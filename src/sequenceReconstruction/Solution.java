package sequenceReconstruction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
The org sequence is a permutation of the integers from 1 to n, with 1 ¡Ü n ¡Ü 10^4. 
Reconstruction means building a shortest common supersequence of the sequences in seqs
(i.e., a shortest sequence so that all sequences in seqs are subsequences of it). 
Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.*/
// it is like course schedule!
// note there can not be 1->2->3->1
public class Solution {
	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
		// if the org is the unique supersequence of seqs
		// then unique nums in org is at least as many as in seqs.
		// but since org is the unique supersequence, then info about neighbors should be enough
		// which means the counts or total length of seqs must be not less than org!!!
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		Map<Integer, Integer> indegree = new HashMap<>();
		for (int num : org) {
			graph.put(num, new HashSet<>());
			indegree.put(num, 0);
		}
		int n = org.length; // nums are 1-n
		int seqCt = 0;
		for (int[] seq : seqs) {
			seqCt += seq.length;
            if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n))
                return false;
            for (int i = 1; i < seq.length; i++) {
                if (seq[i] <= 0 || seq[i] > n)
                    return false;
                if (graph.get(seq[i - 1]).add(seq[i]))
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
            }
        }
		
		if (seqCt < n) {
			return false;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
        for (int key : indegree.keySet()) 
            if (indegree.get(key) == 0)
                q.add(key);
		
        int idx = 0;
        //q.size() == 1!
        while (q.size() == 1) {
            int ele = q.poll();
            for (int next : graph.get(ele)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) q.add(next);
            }
            if (ele != org[idx]) {
                return false;
            }
            idx++;
        }
		// que.size == 0; there might be a cycle, for example: 1->2->3->1.
        // que.size > 1;
        return idx == org.length;
	}
}
