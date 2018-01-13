package BinaryWatch_401;

import java.util.*;

// first came up with this general solution since I thought of PermutationII
// unfinished
public class Solution {
	List<String> res = new ArrayList<>();
	// remember how to make use of swapping to generate all permutations?
	// it is still backtracking, still recursive but swapping!
    public List<String> readBinaryWatch(int num) {
        if (num == 0) {
        	res.add("0:00");
        	return res;
        }
        int[] bits = new int[10];
        for (int i = 0; i < num; i++) {
			bits[i] = 1;
		}
        BackTracking(bits, 0, 10, 0, num);
        return res;
    }

	private void TranslateAndAddtoRes(int[] bits) {
		int hour = 0;
		int minute = 0;
		// remember to check if its legal!!!
		for (int i = 0; i < 4; i++) {
			hour += bits[i] * Math.pow(2, i);
		}
		if (hour > 11) {
			return;
		}
		for (int i = 4; i < bits.length; i++) {
			minute += bits[i] * Math.pow(2, i-4);
		}
		if (minute > 59) {
			return;
		}
		// if its legal, then add to the res!
		String ss = Integer.toString(hour) + ":" + String.format("%02d", minute);
		res.add(ss);
	}

	private void BackTracking(int[] bits, int st, int size, int times, int num) {
		if (times >= num) {
			System.out.print(Arrays.toString(bits));
			TranslateAndAddtoRes(bits);
			return;
		}
		for (int i = st; i < size; i++) {
			swap(bits, st, i);
			BackTracking(bits, st+1, size, times+1, num);
			swap(bits, i, st);
		}
	}

	private void swap(int[] bits, int st, int i) {
		int tp = bits[st];
		bits[st] = bits[i];
		bits[i] = tp;
	}
}
