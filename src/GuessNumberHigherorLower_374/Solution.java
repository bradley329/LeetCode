package GuessNumberHigherorLower_374;

/* The guess API is defined in the parent class GuessGame.
@param num, your guess
@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */

// I pick a number from 1 to n. You have to guess which number I picked.
public class Solution {
    public int guessNumber(int n) {
    	int low = 1;
    	int high = n;
    	// a more safe way is to write low + 1 < high
    	// but now our update rule is low-1 or high+1;
        while (low < high) {
        	int mid = low + (high-low)/2;
        	int guessRes = guess(mid);
        	if (guessRes < 0) {
				high = mid - 1;
			} else if (guessRes > 0) {
				low = mid + 1;
			} else {
				return mid;
			}
        }
        return low;
    }

	private int guess(int guess) {
		// TODO Auto-generated method stub
		int realNum = 10;
		if (realNum < guess) {
			return -1;
		} else if (realNum > guess) {
			return 1;
		} else {
			return 0;
		}
	}
}
