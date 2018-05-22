package Audible;

import java.util.Arrays;

//Ì°ÐÄ£¡

class Pair implements Comparable<Pair>{
	public int cost;
	public int quant;
	public Pair(int cost, int quant) {
		this.cost = cost;
		this.quant = quant;
	}
	@Override
	public int compareTo(Pair o) {
		return this.cost - o.cost;		
	}
}
public class OA3 {
	public static int budgetShopping(int n, int[] quants, int[] costs) {
		if (quants == null || quants.length == 0) {
			return 0;
		}
		int[] dp = new int[n+1];
		int m = quants.length;
		Pair[] temp = new Pair[m];
		for (int i = 0; i < m; i++) {
			temp[i] = new Pair(costs[i], quants[i]);
		}
		Arrays.sort(temp);
		int Min_Cost = temp[0].cost;
		for (int budget = Min_Cost; budget <= n; budget++) {
			for (Pair pair : temp) {
				int cost = pair.cost;
				int quant = pair.quant;
				if (cost > budget) {
					break;
				}
				dp[budget] = Math.max(dp[budget], dp[budget-cost]+quant);
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int[] a = {4,2};
		int[] b = {2,1};
		System.out.println(budgetShopping(5, a, b));
	}
}
