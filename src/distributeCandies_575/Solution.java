package distributeCandies_575;

import java.util.HashSet;
import java.util.Set;

// dont need to use map, set is enough
public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<Integer>();
        for (int item : candies){
            set.add(item);
        }
        return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
    }
}
