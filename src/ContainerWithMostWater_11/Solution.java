package ContainerWithMostWater_11;

// this version is TLE!
// ≤ªπªÕµ¿¡£°
public class Solution {
  public int maxArea(int[] height) {
    if (height == null || height.length < 2) {
      return 0;
    }
    if (height.length == 2) {
      return Math.min(height[0], height[1]);
    }
    int len = height.length;
    int left = Integer.MIN_VALUE;
    int right = Integer.MIN_VALUE;
    int res = 0;
    for (int i = 0; i < len; i++) {
      if (height[i] > left) {
        left = height[i];
      }
      for (int j = len - 1; j > i; j--) {
        if (height[j] > right) {
          right = height[j];
          res = Math.max(res, Math.min(right, left) * (j - i));
        }
      }
      // note this line
      right = Integer.MIN_VALUE;
    }
    return res;
  }
}
