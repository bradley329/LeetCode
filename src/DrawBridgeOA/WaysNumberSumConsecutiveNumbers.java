package DrawBridgeOA;

// length must be at least two
public class WaysNumberSumConsecutiveNumbers {
	public static int fancy(int n) {
		// constraint on values of L gives us the 
        // time Complexity as O(N^0.5)
        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * n; L++)
        {
            float a = (float) ((1.0 * n-(L * (L + 1)) / 2) / (L + 1));
            if (a-(int)a == 0.0) 
                count++;        
        }
        return count;
	}
	
	public static int naive(int n) {
		if (n <= 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		int res = 0;
		for (int i = 1; i <= n/2+1; i++) {
			int sum = 0;
			for (int j = i; j <= n/2+1; j++) {
				sum += j;
				if (sum > n) {
					continue;
				}
				if (sum == n) {
					res++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(naive(15));
		System.out.println(fancy(15));
	}

}
