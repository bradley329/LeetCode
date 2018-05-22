package pocketgems;

public class ConvertTernaryExpressiontoBinaryTree { 
	static int idx = 0;
	private static CharNode convertExpression(char[] exp) {
		// Base case
        if (idx >= exp.length)
            return null;
      
        // store current character of expression_string
        // [ 'a' to 'z']
        CharNode root = new CharNode(exp[idx]);
      
        // Move ahead in str
        idx++;
      
        // if current character of ternary expression is '?'
        // then we add next character as a left child of
        // current node
        if (idx < exp.length && exp[idx]=='?') {
        	idx++;
        	root.left = convertExpression(exp);
        }
        // else we have to add it as a right child of
        // current node expression.at(0) == ':'
        else if (idx < exp.length) {
        	idx++;
        }
        if (root.left != null) {
    		root.right = convertExpression(exp);
		}
        return root;
	}
	
	private static void printTree(CharNode root) {
		if (root == null)
            return;
                 
        System.out.print(root.data +" ");
        System.out.print("left: ");
        printTree(root.left);
        System.out.print("right: ");
        printTree(root.right);
	}
	
	public static void main(String[] args) {
		String ss = "a?b?c:d:e";
		char[] exp = ss.toCharArray();		
		CharNode root = convertExpression(exp);
		printTree(root);
	}
}
