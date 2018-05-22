package MaximumGap_164;

public class Solution {
	public int maximumGap(int[] nums) {
		if (nums.length<2) return 0;
        int minNum = -1, maxNum = -1, n = nums.length;
        for (int i=0; i<n; ++i) {
            minNum = min(nums[i], minNum);
            maxNum = max(nums[i], maxNum);
        }
        if (maxNum==minNum) return 0;
        double average = (maxNum-minNum) * 1.0 / (n - 1);
        if (average==0) ++average;
        int[] localMin = new int[n];
        int[] localMax = new int[n];
        for (int i=0; i<n; ++i) {
            localMin[i] = -1;
            localMax[i] = -1;
        }
        //这个东西很有意思，他是把num以t倍的average为标准分了大小区间，
        //在t+1的min - t的max 就是possible的答案。因为至少是average。
        //在同一区间的就不考虑了.
        for (int i=0; i<n; ++i) {
            int t = (int)((nums[i]-minNum) / average);
            localMin[t] = min(localMin[t], nums[i]);
            localMax[t] = max(localMax[t], nums[i]);
        }
        int ans = (int)average, left = 0, right = 1;
        while (left<n-1) {
            while (right<n && localMin[right]==-1) ++right;
            if (right>=n) break;
            ans = max(ans, localMin[right]-localMax[left]);
            left = right;
            ++right;
        }
        return ans;
    }
    private int min(int a, int b) {
        if (a==-1) return b;
        else 
            if (b==-1) return a;
            else
                if (a<b) return a;
                else return b;
    }
    private int max(int a, int b) {
        if (a==-1) return b;
        else
            if (b==-1) return a;
            else
                if (a>b) return a;
                else return b;    
    }
}
