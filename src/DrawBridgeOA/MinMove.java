package DrawBridgeOA;

public class MinMove {
	// a and b are both integers with digits 0-9'
	public static int[] minMove(int[] a, int[] b) {
		if (a == null || b == null || a.length == 0 || b.length == 0 || a.length != b.length) {
			return null;
		}		
		int len = a.length;
		int[] res = new int[len];
		int m = 0, n = 0;
		for (int i = 0; i < len; i++) {
			int num1 = a[i];
			int num2 = b[i];
			int cnt = 0;
			while (num1 != 0) {
				m = num1 % 10;
				n = num2 % 10;
				cnt += Math.abs(m - n);
				num1 = num1 / 10;
				num2 = num2 / 10;
			}
			res[i] = cnt;
			cnt = 0;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = {1234};
		int[] b = {4321};
		System.out.print(minMove(a, b)[0]);
	}
}
