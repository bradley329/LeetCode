package CourseraOA;

import java.util.*;
import java.util.stream.IntStream;

public class NondominatableEntities {
	public static List<Integer[]> helper(int[][] data) {
		List<Integer[]> res = new ArrayList<>();
		if (data == null || data.length < 1) {
			return res;
		}
		
		Integer[][] boxedData = new Integer[data.length][2];
		for (int i = 0; i < data.length; i++) {
			boxedData[i] = IntStream.of(data[i]).boxed().toArray(Integer[]::new); 
		}
		
		Arrays.sort(boxedData, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] arg0, Integer[] arg1) {
				// reverse order
				return arg1[0].compareTo(arg0[0]);
			}
		});
		printHelper(boxedData);
		int cmax = data[0][1];
		res.add(IntStream.of(data[0]).boxed().toArray(Integer[]::new));
		for (int i = 1; i < data.length; i++) {
			if (data[i-1][0] == data[i][0]) {
				res.add(IntStream.of(data[i]).boxed().toArray(Integer[]::new));
			} else if (cmax <= data[i][1]) {
				res.add(IntStream.of(data[i]).boxed().toArray(Integer[]::new));
		        cmax = data[i][1];
			}
		        
		}  
		return res;
	}
	
	public static void printHelper(Integer[][] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i][0]);
			System.out.print(data[i][1]);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] data = {{3,2},{8,7},{6,7},{6,8},{3,4},{7,9}};
		helper(data);
	}
}
