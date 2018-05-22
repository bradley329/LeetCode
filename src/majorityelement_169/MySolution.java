package majorityelement_169;

import java.util.*;

public class MySolution {
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		int len = nums.length;
		int num = 0;
	    for(int c:nums){
	    	if(m.containsKey(c)){
	    		m.put(c, m.get(c)+1);
	    	}
	    	else{
	    		m.put(c, 1);
	    	}
	    	if(m.get(c)>(len/2)){ 
	    		num = c;
	    		break;
	    	}
	    }
	    return num;
	}
}
