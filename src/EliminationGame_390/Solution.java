package EliminationGame_390;

// dead wrong solution
public class Solution {
    public static int lastRemaining(int n) {
        if (n == 1) {
			return 1;
		}
        if (n <= 3) {
			return 2;
		}
        return (2 + ((n-4)/2) * 2);
    }
    
    public static void main(String[] args) {
		System.out.print(Solution.lastRemaining(11));
	}
}
