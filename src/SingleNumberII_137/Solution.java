package SingleNumberII_137;

// this solution is much more straight forward.
// this solution requires that there is NO number appears two times.
// do not require deriving the logic gate equation.
public class Solution {
  int singleNumber(int A[]) {
    // Initialize result
    int res = 0;
    int n = A.length;
    int x, sum;

    // Iterate through every bit
    for (int i = 0; i < 32; i++) {
      // Find sum of set bits at ith position in all
      // array elements
      sum = 0;
      x = (1 << i);
      for (int j = 0; j < n; j++) {
        if ((A[j] & x) != 0) {
          sum++;
        }
      }

      // The bits with sum not multiple of 3, are the
      // bits of element with single occurrence.
      if (sum % 3 != 0) {
        res |= x;
      }
    }

    return res;
  }
}
