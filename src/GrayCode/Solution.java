package GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  List<Integer> result;
  boolean[] startFromOne;

  public List<Integer> grayCode(int n) {
    result = new ArrayList<>();
    if (n == 0) {
      result.add(0);
      return result;
    }
    int tempSum = 0;
    startFromOne = new boolean[n];
    backTracking(n, tempSum);
    return result;
  }

  private void backTracking(int index, int tempSum) {
    if (index == 0) {
      result.add(tempSum);
      return;
    }
    if (!startFromOne[index - 1]) {
      for (int i = 0; i <= 1; i++) {
        int newSum = (int) (tempSum + i * Math.pow(2, index - 1));
        backTracking(index - 1, newSum);
      }
      // this is the most important idea in my solution!
      startFromOne[index - 1] = !startFromOne[index - 1];
    } else {
      for (int i = 1; i >= 0; i--) {
        int newSum = (int) (tempSum + i * Math.pow(2, index - 1));
        backTracking(index - 1, newSum);
      }
      // this is the most important idea in my solution!
      startFromOne[index - 1] = !startFromOne[index - 1];
    }
  }
}
