package LengthofLastWord_58;

public class Solution {
//	public int lengthOfLastWord(String s) {
//	    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
//	}
	
	public int lengthOfLastWord(String s) {
		// ignoring trailing spaces and count the length of the last word.
		int len = 0, tail = s.length() - 1;
		char[] chaArr = s.toCharArray();
        while (tail >= 0 && chaArr[tail] == ' ') tail--;
        while (tail >= 0 && chaArr[tail] != ' ') {
            len++;
            tail--;
        }
        return len;
	}
	
	public static void main(String[] args) {
		String string = "asdd      ";
		String[] reStrings = string.split(" ");
		System.out.print(reStrings[0]);
	}
}
