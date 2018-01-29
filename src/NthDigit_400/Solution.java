package NthDigit_400;

public class Solution {
    public int findNthDigit(int n) {
        if (n <= 9) {
			return n;
		}
        final int nine = 9;
        int i = 1;
        int preTotalDigits = 9;
        int totalDigits = preTotalDigits + (int) (nine * Math.pow(10, i)* (i+1));
        while (n > totalDigits) {
        	i++;
        	preTotalDigits = totalDigits;
        	totalDigits = preTotalDigits + (int) (nine * Math.pow(10, i)* (i+1));
        }
        int numDigits = i+1;
        int st = (int) Math.pow(10, i);
        int need = n - preTotalDigits;
        int index = (need - 1) / numDigits;
        int mod = (need - 1) % numDigits;
        int lastNum = st + index;
        String number = String.valueOf(lastNum);
        String lastDigit = number.substring(mod, mod+1);
        return Integer.parseInt(lastDigit);
    }
}
