package gasstation_134;

//��Ϊcost�ܺͺ�gas�ܺ��Ѿ�ȷ����
//�𰸻���Ψһ�ġ�һ���Ǵ�gas-cost���Ŀ�ʼ��
//����ⷨ�϶����ԣ�
public class WrongSolution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 0 || cost.length == 0) {
			return -1;
		}
		int sumGas = 0;
		int sumCost = 0;
		int index = -1;
		int max = 0;
        for (int i = 0; i < cost.length; i++) {
        	sumCost += cost[i];
        	sumGas += gas[i];
        	int tp = gas[i] - cost[i];
			if (tp > max) {
				index = i;
				max = tp;
			}
		}
        if (sumCost > sumGas) {
			return -1;
		}
        return index;
    }
}
