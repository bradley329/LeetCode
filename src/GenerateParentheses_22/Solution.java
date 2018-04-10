package GenerateParentheses_22;

import java.util.ArrayList;
import java.util.List;

// ����visualizeһ��DFS����������
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
      // ��ʹ��void�ĺ�����Ҳreturn��һ�㣬���򻹻������������жϣ�
      return;
    }
    if (left < max) {
      BackTracking(curStr + "(", left + 1, right, max, res);
    }
    // ����ط�һ��ʼ��Ȼ�ھ��ᣡ
    if (right < left) {
      BackTracking(curStr + ")", left, right + 1, max, res);
    }
  }
}
