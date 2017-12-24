package FindAllNumbersDisappearedinanArray_448;

import java.util.*;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int n = nums.length;
        // just use the input array as the marking array!
        // note the values are from 1 - n
        for (int i = 0; i < n; i++) {
            int indexOfMarking = Math.abs(nums[i]) - 1;
            // whether this val has been seen?
            if (nums[indexOfMarking] > 0) {
                nums[indexOfMarking] = -nums[indexOfMarking];
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}
