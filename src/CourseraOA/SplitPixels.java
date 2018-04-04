package CourseraOA;

import java.io.*;
import java.util.*;

public class SplitPixels {
	public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        FileInputStream file = new FileInputStream("Pixels.txt");
        Scanner sc = new Scanner(file);
        int line = sc.nextInt();
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Black");
        map.put(1, "White");
        map.put(2, "Red");
        map.put(3, "Green");
        map.put(4, "Blue");
        Map<Double, String> reMap = new HashMap<>();
        PriorityQueue<Double> pq = new PriorityQueue<>((o1, o2) -> (int)(o1 - o2));
        List<List<Integer>> list = new ArrayList<>();
        final int[][] colors = {{0,0,0}, {255,255,255}, {255,0,0}, {0,255,0}, {0,0,255}};
        while (sc.hasNextLine()) {
            String s = sc.next();
            stringToInt(s, list);
        }
        for (List<Integer> subList : list) {
            for (int i = 0; i < colors.length; i++) {
                double d = Math.sqrt(Math.pow(colors[i][0] - subList.get(0), 2) + Math.pow(colors[i][1] - subList.get(1), 2) + Math.pow(colors[i][2] - subList.get(2), 2));
                reMap.put(d, map.get(i));
                pq.add(d);
            }
            double key1 = pq.poll();
            if (key1 == pq.peek()) {
                System.out.println("Ambiguous");
            }
            else System.out.println(reMap.get(key1));
            reMap.clear();
            pq.clear();
        }
        
    }
    public static void stringToInt(String s, List<List<Integer>> list) {
        int left = 0, right = 8;
        List<Integer> subList = new ArrayList<>();
        while (right <= s.length()) {
            String sub = s.substring(left, right);
            char[] subchar = sub.toCharArray();
            int sum = 0;
            for (int i = subchar.length - 1, j = 0; i >= 0; i--, j++) {
                sum += (subchar[i] - '0') * Math.pow(2, j);
            }
            subList.add(sum);
            right += 8;
            left += 8;
        }
        list.add(subList);
        
    }
}
