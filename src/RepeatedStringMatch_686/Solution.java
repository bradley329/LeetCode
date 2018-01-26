package RepeatedStringMatch_686;

// the key point is that the "starter" of B must be a substring of AA!
// or AA contains all starters of B
public class Solution {
    public static int repeatedStringMatch(String A, String B) {
    	int lenA = A.length();
    	int lenB = B.length();
    	String AA = A + A;
    	if (lenB <= lenA) {
    		// first, check if B is already a substring of A:
    		int index = A.indexOf(B);
    		if (index != -1) {
				return 1;
			} else {
				index = AA.indexOf(B);
				if (index != -1) {
					return 2;
				} else {
//					System.out.println("a");
					return -1;
				}
			}
		} else {
			String starter = B.substring(0, lenA);
			// what if A is "abab"
			// AA is "abababab"
			// we have to prove that if we found two Bs in AA
			// the characters after B in AA must be the same!
			int index = AA.indexOf(starter); // index should smaller than lenA
			if (index == -1) {
//				System.out.println("b");
				return -1;
			} else {
				char[] BCharArr = B.toCharArray();
				char[] ACharArr = A.toCharArray();
				// compare the rest characters:
				int BIndex = lenA;
				int AIndex = index;
				int count = 2;
				while (BIndex < BCharArr.length) {
					if (AIndex >= lenA) {
						count++;
						AIndex = 0;
					}
					char BChar = BCharArr[BIndex];
					char AChar = ACharArr[AIndex];
					if (AChar != BChar) {
//						System.out.println("c");
						return -1;
					}
					BIndex++;
					AIndex++;
				}
//				System.out.println("d");
				return count;
			}
		}
    }
    
    public static void main(String[] args) {
    	String A = "abab";
    	String B = "baba";
    	System.out.println(repeatedStringMatch(A, B));
	}
}
