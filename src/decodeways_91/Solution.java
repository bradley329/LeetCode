package decodeways_91;

//because we have a 10, so must take 0 into consideration!
public class Solution {
	public int numDecodings(String s) {
        if(s == null || s.length() <= 0){
    		return 0;
    	}
        
        int len = s.length();
        int[] num = new int[len+1];
        num[0] = 1;
        
        if (s.charAt(0) - '0' != 0) {
        	num[1] = 1;
		} else {
			num[1] = 0;
		}
        
        int sing = 0, doub = 0;
        int dec = 0, unit = 0, doub_num = 0;
        
        for (int i = 2; i <= len; i++) {
        	if (s.charAt(i-1) - '0' != 0) {
        		sing = num[i-1];
        	} else {
        		sing = 0;
        	}
        	dec = s.charAt(i-2) - '0';
        	unit = s.charAt(i-1) - '0'; 
        	doub_num = dec * 10 + unit;
        	if (dec != 0 && doub_num >= 1 && doub_num <= 26) {
        		doub = num[i-2];
        	} else {
        		doub = 0;
        	}
        	num[i] = sing + doub;
        }
        return num[len];
    }
}
