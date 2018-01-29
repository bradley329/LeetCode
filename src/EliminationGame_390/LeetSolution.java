package EliminationGame_390;

public class LeetSolution {
	// mirroring or i call it 左右的结果其实是互补的
	public int lastRemaining(int n) {
		// 在一次elimination之后，剩下了2 * (1,2,3, ..., n/2)，其实就是求“从右往左”(n/2)的结果再乘以2;
		// 但是第二次要“从右往左”，而我们发现“从右往左”的结果和“从左往右”的结果是互补的
	    return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));
	}
}
