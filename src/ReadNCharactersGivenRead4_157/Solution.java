package ReadNCharactersGivenRead4_157;

// the corner case: we may read more than n
public class Solution {
	public int read4(char[] charArr) {
		return 0;
	}
	public int readN(char[] buf, int n) {
        for(int i = 0; i < n; i += 4){
            char[] tmp = new char[4];
            // �����ݶ�����ʱ����
            int len = read4(tmp);
            // ����ʱ���鿽����buf���飬�������ĳ����Ǳ��ζ����ĸ�����ʣ����������н�С��
            System.arraycopy(tmp, 0, buf, i, Math.min(len, n - i));
            // ���������4����˵���Ѿ������ˣ����������賤�Ⱥ�Ŀǰ�Ѿ������ĳ��ȵĽ�С��
            if(len < 4) return Math.min(i + len, n);
        }
        // ���ѭ����û�з��أ�˵����ȡ���ַ���4�ı���
        return n;
    }
}
