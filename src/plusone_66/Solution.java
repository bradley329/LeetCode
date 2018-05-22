package plusone_66;

import java.util.Arrays;

public class Solution {
	public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] pp = new int[len + 1];
        int cc = 1;
        for(int i=len-1; i>=0; i--) {
        	if(digits[i] + cc >= 10) {
        		pp[i+1] = 0;
        		cc = 1;
        	}
        	else {
        		pp[i+1] = digits[i] + cc;
        		cc = 0;
        	}
        }
        if (cc==1) {
        	pp[0] = 1;
        	return pp;
        }
        else {
        	return Arrays.copyOfRange(pp, 1, len+1);
        }
    }
}
