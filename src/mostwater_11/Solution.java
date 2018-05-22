package mostwater_11;
//重点还是在于2 pointers如何偷懒
//而之所以能偷懒的原因是 containner的载水量是由最短的那个决定的。
public class Solution {
    public int maxArea(int[] height) {
        int max = 0; int st = 0; int end = height.length-1;
        while(st<end) {   
        	max = Math.max(max, Math.min(height[st], height[end])*(end-st));
        	if(height[end] < height[st]) {        		          	
        		end--;
        	}else {
        		st++;
        	}        	
        }
        return max;
    }
}
