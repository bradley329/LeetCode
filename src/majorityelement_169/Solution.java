package majorityelement_169;
//this is the top solution
//能这样做的原因是这个majority不是一般的majority
//而是要出现大于n/2的majority
public class Solution {
	public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for(int i=1; i<nums.length;i++) {
            if(count==0){
                count++;
                major = nums[i];
            }else if(major==nums[i]) {
                count++;
            }else count--;
            
        }
        return major;
    }
}
