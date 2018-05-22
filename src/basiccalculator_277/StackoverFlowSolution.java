package basiccalculator_277;

//好像是没有括号的
public class StackoverFlowSolution {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
			return 0;
		}
        s = s.replaceAll("\\s+", "");
        System.out.println(s);
        return helper(s, 0, s.length());
    }
    private static int helper(String s, int st, int end) {
    	if (st == end-1) {
			return Integer.parseInt(s.substring(st, end));
		}
    	int operand2St = st;
    	int operand2End = st;
    	int operand1 = 0;
    	int operand2 = 0;
    	char op = '0';
    	boolean breakoutloop = false;
    	for (int i = st; i < end; i++) {
    		char ch = s.charAt(i);
    		switch (ch) {
			case '+':
				operand2 = Integer.parseInt(s.substring(operand2St, operand2End+1));
				if (op == '*') {
					operand1 = operand1 * operand2;
					operand2 = 0;
				} else if (op == '/') {
					operand1 = operand1 / operand2;
					operand2 = 0;
				} else {
					operand1 = operand2;
					operand2 = 0;
				}
				operand2St = i+1;
				op = '+';
				breakoutloop = true;
				break;
			case '-':	
				operand2 = Integer.parseInt(s.substring(operand2St, operand2End+1));
				if (op == '*') {
					operand1 = operand1 * operand2;
					operand2 = 0;
				} else if (op == '/') {
					operand1 = operand1 / operand2;
					operand2 = 0;
				} else {
					operand1 = operand2;
					operand2 = 0;
				}
				operand2St = i+1;
				op = '-';
				breakoutloop = true;
				break;
			case '*':
				operand2 = Integer.parseInt(s.substring(operand2St, operand2End+1));
				if (op == '*') {
					operand1 = operand1 * operand2;
					operand2 = 0;
				} else if (op == '/') {
					operand1 = operand1 / operand2;
					operand2 = 0;
				} else {
					operand1 = operand2;
					operand2 = 0;
				}
				operand2St = i+1;
				op = '*';
				break;
			case '/':	
				operand2 = Integer.parseInt(s.substring(operand2St, operand2End+1));
				if (op == '*') {
					operand1 = operand1 * operand2;
					operand2 = 0;
				} else if (op == '/') {
					operand1 = operand1 / operand2;
					operand2 = 0;
				} else {
					operand1 = operand2;
					operand2 = 0;
				}
				operand2St = i+1;
				op = '/';
				break;
			default:				
				operand2End = i; 
				break;
			}
    		if (breakoutloop) {
				break;
			}   		
		}
    	if (operand2End == end-1 && operand2St <= operand2End) {
    		if (op == '0') {
    			return Integer.parseInt(s.substring(operand2St, operand2End+1));
			} else if (op == '*') {
				return operand1 * Integer.parseInt(s.substring(operand2St, operand2End+1));
			} else {
				return operand1 / Integer.parseInt(s.substring(operand2St, operand2End+1));
			}
		}
    	System.out.println(operand1);
    	if (op == '+') {
			return operand1 + helper(s, operand2End+2, end);
		} else  {
			return operand1 - helper(s, operand2End+2, end);
		}
    }
    
    public static void main(String[] args) {
    	String string = "3*5+2*3+81";
    	System.out.println(StackoverFlowSolution.calculate(string));
    }
}
