package EliminationGame_390;

public class LeetSolution {
	// mirroring or i call it ���ҵĽ����ʵ�ǻ�����
	public int lastRemaining(int n) {
		// ��һ��elimination֮��ʣ����2 * (1,2,3, ..., n/2)����ʵ�����󡰴�������(n/2)�Ľ���ٳ���2;
		// ���ǵڶ���Ҫ���������󡱣������Ƿ��֡��������󡱵Ľ���͡��������ҡ��Ľ���ǻ�����
	    return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));
	}
}
