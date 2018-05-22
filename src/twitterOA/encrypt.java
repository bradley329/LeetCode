package twitterOA;

//ref:https://www.careercup.com/question?id=5633094794084352
public class encrypt {
	public String decrypt(String input, int[] key) {
		StringBuilder res = new StringBuilder();
		int i = 0;
		for(char c: input.toCharArray()) {
    		if(i == key.length) i = 0;
    		if(Character.isLetter(c)) {
        			char firstLetter = c <= 'Z' ? 'A' : 'a';
        			c = (char)(c - key[i]);
        			if(c < firstLetter) c = (char)(c + 26);
        			i++;
    		}
    		res.append(c);
		}	
		return res.toString();
	}
	
	
}
