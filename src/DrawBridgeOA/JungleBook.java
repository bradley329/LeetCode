package DrawBridgeOA;

import java.util.*;

public class JungleBook {
	// this version pass through the tree multiple times:
	// O(prey number) times
	public int maxHeight(int[] predators){

        int n = predators.length;
        int[] res = new int[n];
        Arrays.fill(res, 1); 
        for (int i = 0; i < n; i++){
            int dir = predators[i];
            if (dir == -1){
                continue;
            } else {
                int pre = i;
                while (dir != -1){
                    res[dir] = Math.max(res[dir], res[pre]+1);
                    pre = dir;
                    dir = predators[dir];
                }
            }
        }

        int max = 0;
        for (int number: res){
            max = Math.max(max, number);
        }

        return max; 
    }

	public static int maxDepth(int[] predators) {
		int n = predators.length;
		int res = 0;
		Map<Integer, Integer> preMap = new HashMap<>();
		Set<Integer> preSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int predatorId = predators[i];
			if (predatorId != -1) {
				preMap.put(i, predatorId);
				preSet.add(predatorId);
			}
		}
		
		// search for the leaves:
		for (int prey : preMap.keySet()) {
			if (!preSet.contains(prey)) {
				// it's the leaf!
				int cnt = 1;
				while (preMap.containsKey(prey)) {
					cnt++;
					prey = preMap.get(prey);
				}
				res = Math.max(res, cnt);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] predators = {-1,0,1};
		System.out.println(maxDepth(predators));
	}
}
