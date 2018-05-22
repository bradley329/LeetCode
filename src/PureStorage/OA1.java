package PureStorage;

public class OA1 {	
	private int extendPalindrome(char[] chArr, int low, int high) {
		int count = 0;
		while (low >= 0 && high < chArr.length && chArr[low] == chArr[high]) {
			low--;
			high++;
			count++;
		}
		return count;
	}
	
	public int countPalindroms(String S) {
        if(S == null || S.length() == 0){
        	return 0;
        }
        char[] chArr = S.toCharArray();
        int len = chArr.length - 1;
        int res = len;
        for (int pivot = 1; pivot < len-1; pivot++) {
	     	res += extendPalindrome(chArr, pivot - 1, pivot);  //Even length 
	     	res += extendPalindrome(chArr, pivot - 1, pivot + 1); //Odd length
	    }
         return res;
      }
}
