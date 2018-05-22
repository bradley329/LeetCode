package fractionrecurring_166;

import java.util.HashMap;

public class BetterSolution {
	public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        if ((numerator > 0) ^ (denominator > 0)) {
            res.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while (num != 0 && !map.containsKey(num)) {
            map.put(num, res.length());
            num *= 10;
            res.append(num / den);
            num %= den;
        }
        if (num != 0) {
            res.insert(map.get(num), "(");
            res.append(")");
        }
        return res.toString();
    }
}
