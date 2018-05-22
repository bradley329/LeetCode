package gasstation_134;

//因为cost总和和gas总和已经确定了
//答案还是唯一的。一定是从gas-cost最大的开始走
//这个解法肯定不对！
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
