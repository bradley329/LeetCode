package NestedListWeightSum_339;

import java.util.*;

public class Solution {
	public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
 
    public int helper(List<NestedInteger> nestedList, int depth){
        if (nestedList == null || nestedList.size() == 0)
            return 0;
        
        // subproblem is all these nested list
        // so for each nested list, they have their own sum
        int sum = 0;
        for(NestedInteger ele : nestedList) {
            if (ele.isInteger()) {
                sum += ele.getInteger() * depth;
            } else {
                sum += helper(ele.getList(), depth + 1);
            }
        }
 
        return sum;
    }
}
