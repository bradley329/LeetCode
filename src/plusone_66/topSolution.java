package plusone_66;

public class topSolution {
	public int[] plusOne(int[] digits) {        
	    int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            //进位到此为止
	            return digits;
	        }	        
	        digits[i] = 0;
	    }	
	    //除非是99999;
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;	    
	    return newNumber;
	}
}
