package copybooks_lintcode;
//this version cost O(n log m) where n is the number of books and m is the sum of the pages.
//������кܶ������������¿�����ô��
//���� ��ֻ�����Ǹ����䵽����ȫ�����꣬���ֹܷ�
//���ߣ�һ�����������ġ�������
//���ʹ��check��function�ܺ�д
public class BinarySearch {
	public int copyBooks(int[] pages, int k) {
        // write your code here
		if (pages == null && pages.length ==0) {
			return 0;
		}
		int max = pages[0];
		int total = 0;
		for (int i = 0; i < pages.length; i++) {
            total += pages[i];
            if (max < pages[i]) {
                max = pages[i];
            }
        }        
        int start = max;
        int end = total;
		//��ʼ�²�
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (checkCopiers(pages, mid) > k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (checkCopiers(pages, start) <= k) {
            return start;
        }
        
        return end;
    }
	
	int checkCopiers(int[] pages, int guess) {
		int copiers = 1;
        int sum = pages[0]; // guess is always >= pages[0]
        //������ע�����Ϊɶ����ôֱ��ȷ��������
        for (int i = 1; i < pages.length; i++) {
            if (sum + pages[i] > guess) {
                copiers++;
                sum = 0;
            }
            sum += pages[i];
        }        
        return copiers;
	}
}
