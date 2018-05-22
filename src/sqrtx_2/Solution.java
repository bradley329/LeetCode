package sqrtx_2;
//��ɸ���ȷ�ķ���double;
public class Solution {
	public double sqrt(double x) {
        // Write your code here
		double left = 0.0;
        double right = x;
        double eps = 1e-12;
        if(right < 1.0) {
            right = 1.0;
        }
        while(right - left > eps) {
            // ���ָ����� �Ͷ���������ͬ
            // һ�㶼��һ�����ȵ�Ҫ�� Ʃ���������Ҫ��С������λ
            // Ҳ����ֻҪ���Ƕ��ֵĽ���ﵽ��������ȵ�Ҫ��Ϳ���
            // ���� ��Ҫ�� right �� left С��һ�����������趨�õľ���ֵ eps
            // һ��eps���趨1e-8,��Ϊ�����Ҫ���ǵ�1e-8,�����ҰѾ��ȵ�����1e-12
            // ��� ѡ�� left �� right ��Ϊһ��������� 
            double mid = (right + left) / 2;
            if(mid * mid <= x) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}
