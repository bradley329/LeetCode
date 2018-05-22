package traprainwater_42;

public class DP {
    public int trap(int[] height) {
    	if (height == null || height.length == 0) {
			return 0;
		}
        int ans = 0;
        int len = height.length;
        int[] left_max = new int[len];
        int[] right_max = new int[len];
        left_max[0] = height[0];
        right_max[len-1] = height[len-1];
        for (int i = 1; i < len; i++) {
			left_max[i] = Math.max(height[i], left_max[i-1]);
		}
        for (int j = len-2; j >= 0; j--) {
			right_max[j] = Math.max(height[j], right_max[j+1]);
		}
        for (int i = 1; i < len-1; i++) {
			ans += Math.min(left_max[i], right_max[i]) - height[i];
		}
        return ans;
    }
    //下面这个是个小优化，即rightmax可以不用数组存，而是在第三个for循环的时候顺便以max记录；
    public int trap2(int[] height) {
    	if (height == null || height.length == 0) {
			return 0;
		}
        int ans = 0;
        int len = height.length;
        int[] left_max = new int[len];
        //int[] right_max = new int[len];
        left_max[0] = height[0];
        //right_max[len-1] = height[len-1];
        for (int i = 1; i < len; i++) {
			left_max[i] = Math.max(height[i], left_max[i-1]);
		}
        int max = 0;
        for (int i = len - 1; i >= 0; i--) {
            ans += Math.min(max, left_max[i]) > height[i]
                    ? Math.min(max, left_max[i]) - height[i]
                    : 0;
            max = Math.max(max, height[i]);
        }       
        return ans;
    }
}
