package NondecreasingArray_665;

// did not realize that it could be solved greedy
public class Solution {
    /*public boolean checkPossibility(int[] nums) {
        if (nums.length < 2) {
			return true;
		}
        boolean haveOne = false;
        int preMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] < preMax) {
				if (nums[i] > preMax) {
					preMax = nums[i];
				}
			} else {
				if (haveOne) {
					return false;
				} else {
					haveOne = true;
				}
			}
		}
        return true;
    }*/
	
	public boolean checkPossibility(int[] nums) {
        boolean modified = false; 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (modified) {
                    return false;
                } else {
                    modified = true;
                    // note this is where greedy is
                    // if i-2 is also bigger that i
                    // then we want to modify i instead of i-1
                    if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    }
                }
            }
        }
        return true;
    }
}
