package Workday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EateLeaves {
	static int countUneatenLeaves(int n, int[] a) {
		int k = a.length;
		int unEatenLeaves = n;
		int eatenLeaves = 0;
		int[] marks = new int[n+1];
		for (int i = 0; i < k; i++) {
			int jump = a[i];
			int j = 1;
			int leafToEat = j * jump;
			while (leafToEat <= n) {
				if (marks[leafToEat] == 0) {
					marks[leafToEat] = 1;
					eatenLeaves++;
				}
				j++;
				leafToEat = j * jump;
			}
		}
		unEatenLeaves = n - eatenLeaves;
		return unEatenLeaves;
    }
	
	public static int findUneatenLeaves(int n, int[] a) {
		Arrays.sort(a);
		int k = a.length;
        int startLeaf = a[0];
        int uneaten = startLeaf-1;
        int j;
        while(startLeaf <= n) {
            j = 0;
            while(j < k) {
            	System.out.println(j);
                if((startLeaf % a[j]) == 0 ) {
                	System.out.println(j);
                	break;
                }
                j++;
                System.out.println(j);
            }
            if(j >= k) {
            	System.out.println("sdada");
            	uneaten++;
            }
            startLeaf++;
        }
        return uneaten;
    }
	public static void main(String[] args) {
		int[] a = {2,4,5};
		System.out.println(findUneatenLeaves(10, a));
	}
	
	 static int countUneatenLeavesII(int n, int[] a) {
/*	        if(n <= 0)
	            return 0;
	        if (a == null || a.length == 0)
	            return 0;*/

	        int k = a.length;
	        Set<Integer > eaten = new HashSet<Integer>();
	        Arrays.sort(a);
	        for(int i = 0 ; i < k; i++){
	        	int jump = a[i];
	            if(eaten.contains(a[i]))
	                continue;
	            else {
	            	int nextLeave = jump;
	            	while(nextLeave <=  n){
	            		if(!eaten.contains(nextLeave))
	            			eaten.add(nextLeave);
	            		nextLeave += jump;
	            	}	
		        }
	        }
	        return (n - eaten.size());
	}
}
