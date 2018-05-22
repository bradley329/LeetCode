package pocketgems;

import java.util.PriorityQueue;

// this is when two rods dont have to be adjacent
public class CombineRod_Greedy {
	public static int stoneGame(int[] A) {
		if (A.length <= 1) {
			return 0;
		}
		int res = 0;
		int rod1 = 0, rod2 = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : A) {
			pq.offer(num);
		}
		// len is at least two:
		while (pq.size() > 1) {
			rod1 = pq.poll();
			rod2 = pq.poll();
			int newrod = rod1 + rod2;
			pq.offer(newrod);
			res += newrod;
		}
		return res;
    }
	
	public static void main(String[] args) {
		System.out.print(stoneGame(new int[]{4, 4, 5, 9}));
	}
}
