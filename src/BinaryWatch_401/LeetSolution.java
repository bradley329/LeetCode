package BinaryWatch_401;

import java.util.*;

// it saves time since it update the sum as we go
// also check if hour and minute is good as we go
public class LeetSolution {
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1};
        int[] nums2 = new int[]{32, 16, 8, 4, 2, 1};
        for(int i = 0; i <= 4 && i <= num; i++) {
            if(num - i > 6) continue;
            List<Integer> list1 = generateDigit(nums1, i); // hour
            List<Integer> list2 = generateDigit(nums2, num - i); // minitues
            for(int num1: list1) {
                if(num1 >= 12) continue;
                for(int num2: list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }
    
    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }
    
    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if(count == 0) {
            res.add(sum);
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
	}
}
