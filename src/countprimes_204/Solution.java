package countprimes_204;

public class Solution {
	public int countPrimes(int n) {
        int res = 0;
        boolean[] not_prime = new boolean[n];
        for (int i = 2; i < n; i++) {
        	//��ȷ�ԣ�һ���ܱ�֤==falseһ���������ģ���������Ϊ��ʼ��
        	//��Ϊ������������ģ������Ķ�����Ǳ���С�������
        	//�����Լ�֮ǰ�����г˻�������ˣ���ô�������false �Ǳ�������!
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
