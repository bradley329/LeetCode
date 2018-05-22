package arrayPartitionI_561;

public class BucketSortSolution {
	public int arrayPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int n : nums) max = Math.max(n+10000, max);
        int[] bucket = new int[max+1];
        for(int n:nums) bucket[n+10000]++;
        int count = 0, res = 0;
        for(int i=0;i<bucket.length;i++){
            while(bucket[i]>0){
                bucket[i]--;
                if((count++)%2==0) res+=i-10000; 
            }
        }
        return res;
    }
}
