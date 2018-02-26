package LargestNumber_179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  public static String largestNumber(int[] nums) {
    if (nums == null)
      return null;
    if (nums.length <= 1)
      return Integer.toString(nums[0]);
    String[] ss = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      ss[i] = Integer.toString(nums[i]);
    }
    // the comparator should sort in "descending" orders!
    Comparator<String> c = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
          return Integer.compare(Integer.parseInt(o2.toString()), Integer.parseInt(o1.toString()));
        } else {
          String s1 = o1 + o2;
          String s2 = o2 + o1;
          return s2.compareTo(s1);
        }
      }
    };
    Arrays.sort(ss, c);
    StringBuilder ssBuilder = new StringBuilder();
    // since we have sorted the array, so the line below is safe!
    if (ss[0].charAt(0) == '0')
      return "0";
    for (int i = 0; i < nums.length; i++) {
      ssBuilder.append(ss[i]);
    }
    return ssBuilder.toString();
  }

  public static void main(String[] args) {
    System.out.println(largestNumber(new int[] {62, 58, 36, 59, 4, 16, 82, 67, 13, 41, 31, 29, 53,
        56, 43, 96, 56, 43, 46, 45, 7, 65, 9, 9, 96, 99, 95, 84, 94, 27, 69, 88, 38, 25, 77, 44, 38,
        37, 1, 94, 49, 78, 4, 99, 99, 22, 7, 60, 37, 17, 42, 48, 41, 88, 57, 17, 92, 1, 51, 51, 82,
        34, 8, 3, 84, 29, 23, 5, 19, 1, 28, 76, 32, 33, 70, 94, 95, 8, 72, 35, 99, 50, 80, 14, 11,
        78, 4, 38, 99, 65, 11, 71, 52, 68, 22, 32, 1, 26, 82, 28}));
  }
}
