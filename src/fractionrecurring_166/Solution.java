package fractionrecurring_166;

import java.util.*;

class Solution {
    public String fractionToDecimal(int num, int den) {
    	boolean isNeg = false;
    	long denominator = den;
    	long numerator = num;
		if (num>0 && den<0 ) {
			isNeg = true;
			denominator = -denominator;
		}
		if (num<0 && den>0 ) {
			isNeg = true;
			numerator = -numerator;
		}
		if (num<0 && den<0 ) {
			denominator = -denominator;
			numerator = -numerator;
		}
        long intPart = (numerator / denominator);
        long mod = (numerator % denominator);
        if (den == -den) {
        	 System.out.println(true);
		}
        System.out.println(numerator);
        System.out.println(denominator);
        if (mod == 0) {
			return isNeg ? "-"+Long.toString(intPart) : Long.toString(intPart);
		}
	    Map<Long, Integer> map = new HashMap<>();
        String res = Long.toString(intPart) + ".";
        int index = res.length()-1; 
        numerator = mod * 10;
        mod = (numerator % denominator);
        intPart = (numerator / denominator);
        while (!map.containsKey(numerator)) {
            res += Long.toString(intPart);
            if (mod == 0) {
				break;
			}
			index++;
			map.put(numerator, index);			
			numerator = mod * 10;
	        mod = (numerator % denominator);
	        intPart = (numerator / denominator);
	        System.out.println(intPart);
		}
        if (map.containsKey(numerator)) {
        	char[] chararr = new char[res.length()+2];
        	int stIndex = map.get(numerator);
        	System.out.println(stIndex);
        	for (int i = 0; i < stIndex; i++) {
				chararr[i] = res.charAt(i);
			}
        	chararr[stIndex] = '(';
        	for (int i = stIndex; i <= index; i++) {
				chararr[i+1] = res.charAt(i);
			} 
        	chararr[index+2] = ')';
        	if (isNeg) {
				res = "-" + String.valueOf(chararr);
			} else {
                res = String.valueOf(chararr);
            }
        	return res;
		}
        if (isNeg) {
			res = "-" + res;
		}
    	return res;
    }
}