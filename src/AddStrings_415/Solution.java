package AddStrings_415;

public class Solution {
	public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        String result = "";
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            result = carry % 10 + result; // note that result is a string
            carry /= 10;
        }
        return carry > 0 ? "1" + result : result;
    }
	
	public String addStringsII(String num1, String num2) {
		// this version uses a stringbuilder
        int carry = 0;
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        StringBuilder strb = new StringBuilder();
        while (index1>=0 || index2>=0 || carry>0) {
            if (index1>=0) carry += num1.charAt(index1)-'0';
            if (index2>=0) carry += num2.charAt(index2)-'0';
            strb.append(carry%10);
            carry = carry/10;
            index1--;
            index2--;
        }
        return strb.reverse().toString();
    }
}
