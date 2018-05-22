package fourSumII;

import java.util.HashMap;
import java.util.Map;

//very intuitive solution
public class SolutionI {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		
		Map<Integer,Integer> sums = new HashMap<>();
		int count = 0;
		
		for(int i = 0; i < A.length; i++) {
			for(int j=0; j < B.length; j++){
				int sum = A[i] + B[j];
				sums.put(sum, sums.getOrDefault(sum, 0)+1);
			}
		}
		
		for(int k = 0; k < A.length; k++) {
			for(int z = 0; z < C.length; z++){
				int sum = -(C[k] + D[z]);
				if(sums.containsKey(sum)) {
					count+=sums.get(sum);
				}
			}
		}
		
		return count;
    }
}
