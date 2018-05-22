package Intuit_Phone;

import java.util.*;

public class MeetingRoom {
	public static boolean canMeet(int[][] meetings, int st, int end) {
		Comparator<int[]> comparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		};
		Arrays.sort(meetings, comparator);
//		System.out.println(meetings[0][0]);
		if (end <= meetings[0][0]) {
			return true;
		}
		for (int[] meeting : meetings) {
			if (st >= meeting[1]) {
				continue;
			}
			if (st >= meeting[0] && st < meeting[1] || end > meeting[0] && end <= meeting[1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] meetings = {{1300, 1500}, {930, 1200},{830, 845}};
		System.out.println(canMeet(meetings, 1200, 1300));
	}
}
