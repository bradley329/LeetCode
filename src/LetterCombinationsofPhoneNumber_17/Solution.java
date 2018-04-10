package LetterCombinationsofPhoneNumber_17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private static final String[] keySet =
      {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits == null || digits.length() == 0)
      return res;

    backTracking("", res, digits, 0);
    return res;
  }

  private void backTracking(String curStr, List<String> res, String digits, int curIdx) {
    if (curIdx >= digits.length()) {
      res.add(curStr);
      return;
    }
    int i = digits.charAt(curIdx) - '0';
    String letters = keySet[i];
    for (char letter : letters.toCharArray()) {
      backTracking(curStr + letter, res, digits, curIdx + 1);
    }
  }
}
