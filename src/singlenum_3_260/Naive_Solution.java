package singlenum_3_260;
import java.util.*;
//naive solution using hashset
public class Naive_Solution {
    public static int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num:nums) {
        	if(!set.add(num)) {
        		set.remove(num);
        	}
        }
        int[] res = new int[set.size()];
        int c = 0;
        for(int x:set)
        {
        	res[c++] = x;
        }
        return res;
    }
    public static void main(String[] args)
    {
    	int[] nums = {1,2,1,2,3,5};
    	int[] res = singleNumber(nums);
    	System.out.println(res[0]);
    }
}
