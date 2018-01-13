package PascalsTriangleII_119;

import java.util.*;
// next[k] = pre[k] + pre[k-1]
// in order to reuse the array, rather than declare a new array each row,
// the key point is to fill the array from end to beginning!!!
public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	if (rowIndex < 0) {
			return null;
		}
    	// note if not Integer array, have to box to use Arrays.asList..
    	Integer[] res =  new Integer[rowIndex + 1];
        Arrays.fill(res, 0);
        res[0] = 1;
        for(int i = 1; i < rowIndex + 1; i++) {
//        	fill the array from end to beginning
        	for(int j = i; j >= 1; j--) {
        		res[j] += res[j - 1];
        	}
        }
        return Arrays.asList(res);
    }
}
