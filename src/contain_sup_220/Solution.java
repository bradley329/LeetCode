package contain_sup_220;
//not find duplicate;
//the idea of sliding window is kinda right but complicated;
//now we use the idea of bucket sort;
//note that -1/5 = 0 which is not what we expect
import java.util.*;

public class Solution {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
    public static void main(String[] args)
    {
    	int nums[] = {-2,-1,-5,-10,-11,-12,-13,-14,-15};
    	System.out.println(containsNearbyAlmostDuplicate(nums, 2, 2));
    }
}