package ThirdMaximumnumber_414;

import java.util.*;

// a more general version is the Top K elements
// The time complexity must be in O(n).
// using a size 3 PQ?
public class Solution {
	public int thirdMax(int[] nums) {
        if (nums.length==1) return nums[0];
        else if(nums.length==2) return Math.max(nums[0], nums[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() < 3 && !pq.contains(num)) {
                pq.add(num);
                continue;
            } else if (num > pq.peek() && !pq.contains(num)) {
                pq.poll();
                pq.add(num);
            }
        }
        
        // when less than 3, return the largest
        if(pq.size() < 3) {
            while(pq.size() != 1) pq.poll();
        }
        
        return pq.peek();
    }
}
