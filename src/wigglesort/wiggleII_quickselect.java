package wigglesort;

public class wiggleII_quickselect {
	public static void wiggleSort(int[] nums) {
		//��Ͳ���O(1) space
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        int mid = partition(temp, 0, nums.length-1, nums.length/2);
        //Ϊʲô����ֱ��inplace partition nums?
        //��Ϊ���mid����ȵļ��� �ҷֱ���mid���Ҿʹ��ˣ�
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = mid;
        }
        int l, r;
        //���ע�⣬���ǵ�mid��nums.length/2������(nums.length-1)/2
        //������<��ͷ
        if (nums.length % 2 == 0) {
            l = nums.length - 2;
            r = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l -= 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r += 2;
                }
            }
        } else {
            l = 0;
            r = nums.length - 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l += 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r -= 2;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }
	//����quicksort��quickselect
    public static int partition(int[] nums, int l, int r, int rank) {
        int left = l, right = r;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        //nums[left] = pivot;
        if (left - l == rank) {
            return pivot;
        } else if (left - l < rank) {
            return partition(nums, left + 1, r, rank - (left - l + 1));
        } else {
            return partition(nums, l, right - 1, rank);
        }
    }
}
