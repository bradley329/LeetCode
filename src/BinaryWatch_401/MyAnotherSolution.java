package BinaryWatch_401;

import java.util.*;

public class MyAnotherSolution {
	List<String> res = new ArrayList<>();
	public List<String> readBinaryWatch(int num) {
		if (num == 0) {
        	res.add("0:00");
        	return res;
        }
		int[] bits = new int[10];
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
	
	private void BackTracking(int[] bits, int st, int end, int times, int num) {
		if (times >= num) {
//			System.out.print(Arrays.toString(bits));
			TranslateAndAddtoRes(bits);
			return;
		}
		for (int i = st; i < end; i++) {
			if (bits[i] == 1) {
				continue;
			}
			bits[i] = 1;
			// note it should be i+1 instead of st!
			BackTracking(bits, i+1, end, times+1, num);
			bits[i] = 0;
		}
	}
}
