package productexceptself_238;

public class ClearSolution {
	public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftPart = new int[len]; leftPart[0] = 1;
        int[] rightPart = new int[len]; rightPart[len-1] = 1;
        int[] res = new int[len];
        for(int i=1; i<len; i++) {
        	leftPart[i] = leftPart[i-1]*nums[i-1];
        }
        for(int j=len-2; j>=0; j--) {
        	rightPart[j] = rightPart[j+1]*nums[j+1];
        }
        for(int k=0; k<len; k++) {
        	res[k] = leftPart[k]*rightPart[k];
        }
        return res;        
    }
}
