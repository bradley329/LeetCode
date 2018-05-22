package Audible;

public class OA1 {
	public static long SubArraySum(int arr[] , int n )
    {
        long sum = 0;
      
        // computing sum of subarray using formula
        for (int i=0; i<n; i++) {
        	sum += arr[i] * (i+1) * (n-i);
        }    
        return sum;
    }
     
    /* Driver program to test above function */
    public static void main(String[] args) 
    {
        int arr[] = {1, 2, 3} ;
        int n = arr.length;
        System.out.println("Sum of SubArray " + 
                           SubArraySum(arr, n));
    }
}
