package subarraysum_2;
//因为sum数组是个递增数组啊
//然后就只找那两下界和上界点
public class binarysolution {
	int find(int[] A, int len, int value) {
        if (A[len-1] < value )
            return len;
        
        int l = 0, r = len-1, ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (value <= A[mid]) {
                ans = mid;
                r = mid - 1;
            }  else
                l = mid + 1;
        }
        return ans;
    }
    
    
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        int len = A.length;
        for (int i = 1; i <len; ++i)
            A[i] += A[i-1];

        int cnt = 0;
        for (int i = 0; i <len; ++i) {
            if (A[i] >= start && A[i] <= end)
                cnt ++;
            int l = A[i] - end;
            int r = A[i] - start;
            //这个r+1是很容易出错的
            cnt += find(A, i+1, r+1) - find(A, i+1, l); 
        }
        return cnt;
    }
}
