package countprimes_204;

public class Solution {
	public int countPrimes(int n) {
        int res = 0;
        boolean[] not_prime = new boolean[n];
        for (int i = 2; i < n; i++) {
        	//正确性：一定能保证==false一定是质数的，而不是因为初始化
        	//因为如果不是质数的，质数的定义就是比他小的数相乘
        	//在他自己之前的所有乘积都算过了，那么如果还是false 那必是质数!
			if (not_prime[i] == false) {
				res++;
				int j = i;
				long notPrime = ((long)i) * ((long)j);
				while (notPrime < n) {
					not_prime[(int) notPrime] = true;
					j++;
					notPrime += ((long)i);
				}
			}
		}
        return res;
    }
	public static void main(String[] args) {
		System.out.println((long)499979*(long)499979);
	}
}
