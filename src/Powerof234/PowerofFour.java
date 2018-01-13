package Powerof234;

public class PowerofFour {
	public boolean isPowerOfFour(int n) {
		/*First, Any number passes ¡°n^(n-1)==0¡± must be powers of 2;
		Second, all numbers above could be further categorized to 2 class: 
			A: all numbers that are 2^(2k+1); 
			B: all numbers that 2^(2k).
		Finally, we could show that 2^(2k+1)-1 could not pass the test of (n-1)%3==0. (by induction) 
		So all A are ruled out, leaving only B, which is power of 4.*/
        return n > 0 && ((n - 1) & n) == 0 && (n - 1) % 3 == 0;
    }
	
	public boolean isPowerOfFourII(int n) {
		return n > 0 && ((n - 1) & n) == 0 && (n & 0x55555555) != 0;
	}
}
