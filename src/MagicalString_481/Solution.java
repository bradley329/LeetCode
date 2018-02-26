package MagicalString_481;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public int magicalString(int n) {
    if (n <= 0)
      return 0;
    if (n <= 3)
      return 1;
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2));
    int res = 1;
    int size = 3;
    int indexOfCount = 2;
    int nextNum = 1;
    while (size < n) {
      int count = list.get(indexOfCount);
      for (int i = 0; i < count; i++) {
        list.add(nextNum);
        size++;
        if (nextNum == 1 && size <= n) {
          res++;
        }
      }
      nextNum ^= 3;
      indexOfCount++;
    }
    return res;
  }
}
