package CourseraOA;

import java.util.Scanner;

//±Æ½ü¼«µã
public class CuttingMetals {
	public int maxProfit(int cutCost, int unitPrice, int[] lengths) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//	    Scanner sc = new Scanner(System.in);
//	    int cutCost = Integer.parseInt(sc.next());
//	    int unitPrice = Integer.parseInt(sc.next());
//	    int L = Integer.parseInt(sc.next());
//	    int[] lengths = new int[L];
//	    int i = 0;
//	    while (sc.hasNextLine()) {
//	        lengths[i] = Integer.parseInt(sc.next());
//	        i++;
//	    }
	    int maxprofit = 0;
	    int maxLength = 0;
	    int profit = 0;
	    for (int len : lengths) {

	        if (len > maxLength) maxLength = len;//find maxlength
	    }
	    // should use binary search instead
	    for (int i = 1; i < maxLength; i++) {
	        int sumChunk = 0;
	        int sumCut = 0;
		    for (int len : lengths) {
		    //cut length
		        int chunk = len / i;
		        int res = len % i;
		        if (res == 0) { //没有余
	
		            sumCut += chunk - 1;
		            sumChunk += chunk;
	
		        }
		        else {//有剩余
		            sumCut += chunk;
		            sumChunk += chunk;
		        }
		    }
		    profit = Math.max(profit, sumChunk * i * unitPrice - sumChunk * cutCost);
	    }
	    System.out.println(profit);
	    return profit;
	}
}
