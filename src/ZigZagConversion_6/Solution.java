package ZigZagConversion_6;

public class Solution {
  public String convert(String s, int numRows) {
    if (numRows <= 1 || s.length() <= numRows)
      return s;
    int len = s.length();
    StringBuilder str = new StringBuilder();
    int st = 0;
    int index = 0;
    int up = numRows + numRows - 2;
    while (index < len) {
      str.append(s.charAt(index));
      index += up;
    }
    /*
    P   A   H   N
    A P L S I I G
    Y   I   R
    */
    st++;
    while (st < numRows - 1) {
      str.append(s.charAt(st)); // A
      index = up;
      // 一个周期一个周期的看
      // PL->SI->IG
      while (index - st < len) {
        str.append(s.charAt(index - st));
        if (index + st < len)
          str.append(s.charAt(index + st));
        index += up;
      }
      st++;
    }
    // last row
    index = st;
    while (index < len) {
      str.append(s.charAt(index));
      index += up;
    }
    return str.toString();
  }
}
