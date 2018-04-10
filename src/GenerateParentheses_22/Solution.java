package GenerateParentheses_22;

import java.util.ArrayList;
import java.util.List;

// 还是visualize一个DFS的树最好理解
public class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    if (n < 1) {
      return res;
    }
    BackTracking("", 0, 0, n, res);
    return res;
  }

  private void BackTracking(String curStr, int left, int right, int max, List<String> res) {
    if (curStr.length() >= max * 2) {
      res.add(curStr);
      // 即使是void的函数，也return好一点，否则还会走下面两个判断；
      return;
    }
    if (left < max) {
      BackTracking(curStr + "(", left + 1, right, max, res);
    }
    // 这个地方一开始居然在纠结！
    if (right < left) {
      BackTracking(curStr + ")", left, right + 1, max, res);
    }
  }
}
