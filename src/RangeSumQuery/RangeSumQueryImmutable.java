package RangeSumQuery;

// this is the easy version of Range Sum Query.
public class RangeSumQueryImmutable {
	private int[] nums;
	private int[] sums; // sums[i] means the sum from 0 ~ i-1
	// note that sums[0] = 0;
	public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
			sums[i] = sums[i-1] + nums[i-1];
		}
    }
    
    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
	public static void main(String[] args) {
	}

}
