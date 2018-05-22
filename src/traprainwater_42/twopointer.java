package traprainwater_42;

public class twopointer {
	public int trapRainWater(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
        // write your code here
        int left = 0, right = height.length - 1; 
        int res = 0;
        int leftheight = height[left];
        int rightheight = height[right];
        while(left < right) {
            if(leftheight < rightheight) {
                left ++;
                if(leftheight > height[left]) {
                    res += (leftheight - height[left]);
                } else {
                    leftheight = height[left];
                }
            } else {
                right --;
                if(rightheight > height[right]) {
                    res += (rightheight - height[right]);
                } else {
                    rightheight = height[right];
                }
            }
        }
        return res;
    }
}
