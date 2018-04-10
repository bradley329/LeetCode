package ContainerWithMostWater_11;

public class LeetSolution {
  public int maxArea(int[] height) {
    int max = 0;
    int st = 0;
    int end = height.length - 1;
    while (st < end) {
      max = Math.max(max, Math.min(height[st], height[end]) * (end - st));
      if (height[end] < height[st]) {
        end--;
      } else {
        st++;
      }
    }
    return max;
  }
}
