package ConstructtheRectangle_492;

public class Solution {
	// this solution is the version everyone could think of
	public int[] constructRectangle(int area) {
        for (int w = (int) Math.sqrt(area); w > 0; w--) {
            if (area % w == 0) return new int[]{area / w, w};
        }
        return new int[]{0, 0};
    }
}
