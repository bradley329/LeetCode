package keyboardRow_500;

import java.util.*;

public class Solution {
	private final Set<Character> first = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
	private final Set<Character> second = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
	private final Set<Character> third = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
	private final List<Set<Character>> rows = new ArrayList<Set<Character>>(Arrays.asList(first,second,third));
	public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        mainloop:
        for (String word : words) {
        	char[] chArr = word.toLowerCase().toCharArray();
        	char st = chArr[0];
        	int idx = 0;
        	boolean found = false;
        	for (int i = 0; i < 3; i++) {
				if (rows.get(i).contains(st)) {
					idx = i;
					found = true;
					break;
				}
			}
        	if (!found) {
				continue;
			}
        	Set<Character> curSet = rows.get(idx);
        	for (int i = 1; i < chArr.length; i++) {
        		if (!curSet.contains(chArr[i])) {
					continue mainloop;
				}
        	}
        	res.add(word);
        }
        String[] myRes = res.toArray(new String[res.size()]);
        return myRes;
    }
}
