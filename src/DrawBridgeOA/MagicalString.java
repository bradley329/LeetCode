package DrawBridgeOA;

// a magical string is a string which only have 'aeiou'
// and observe the follow rules:
/*"a" must only be followed by "e".
"e" must only be followed by "a" or "i".
"i" must only be followed by "a", "e", "o", or "u".
"o" must only be followed by "i" or "u".
"u" must only be followed by "a".*/
public class MagicalString {
	public static int magicalStrings(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 5;
		}
		// 'a', 'e', 'i', 'o', and 'u'.
		int[][] dp = new int[5][n+1];
		for (int i = 0; i < 5; i++) {
			dp[i][1] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 5; j++) {
				switch (j) {
				case 0: // 'a'
					// 'e', 'i', 'u'
					dp[j][i] = dp[1][i-1] + dp[2][i-1] + dp[4][i-1];
					break;
					
				case 1: // 'e'
					// 'a', 'i'
					dp[j][i] = dp[0][i-1] + dp[2][i-1];
					break;
				case 2: // 'i'
					// 'e', 'o'
					dp[j][i] = dp[1][i-1] + dp[3][i-1];
					break;
				case 3: // 'o'
					// 'i'
					dp[j][i] = dp[2][i-1];
					break;
				case 4: // 'u'
					// 'i', 'o'
					dp[j][i] = dp[2][i-1] + dp[3][i-1];
					break;
				default:
					break;
				}
			}	
		}
		int sum = 0;
		for (int i = 0; i < 5; i++) {
//			System.out.println(dp[i][n]);
			sum += dp[i][n];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(magicalStrings(3));
	}
}
