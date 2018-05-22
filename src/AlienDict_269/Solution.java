package AlienDict_269;

import java.util.*;

class AlienChar {
	public char c;
	public int in;
	public Set<Character> next;
	public AlienChar(char c) {
		// TODO Auto-generated constructor stub
		this.c = c;
		this.in = 0;
		this.next = new HashSet<>();
	}
}
public class Solution {
	public String alienOrder(String[] words) {
		//set其实没必要了
		Set<Character> allch = new HashSet<>();
		Map<Character, AlienChar> map = new HashMap<>();
		int n = words.length;
		//所有出现的char都加入map
		for (String word : words) {
			for (char c : word.toCharArray()) {
				if (allch.add(c)) {
					map.put(c, new AlienChar(c));
				}
			}
		}
		for (int i = 0; i < n-1; i++) {
			int len1 = words[i].length();
			int len2 = words[i+1].length();
			int min = Math.max(len1, len2); 
			for (int j = 0; j < min; j++) {
				if (words[i].charAt(j) != words[i+1].charAt(j)) {
					//父子关系是完全可能重复的！！
					if (map.get(words[i].charAt(j)).next.add(words[i+1].charAt(j))) {
						map.get(words[i+1].charAt(j)).in++;
					}
					//break的原因是后面并不是lexical order
					break;
				}
				//以下判断其实是input里就有不符合lexical的，即wrt & wr，应该是wr在前
				if (j == min && words[i].length() > words[i + 1].length()) return "";
			}
		}
		Queue<Character> que = new LinkedList<>();
		String res = "";
		for (char ch : allch) {
            if (map.get(ch).in == 0) {
                que.offer(ch);
                res += ch;
            } 
        }
		while (!que.isEmpty()) {
            char c = que.poll();
            for (char child : map.get(c).next) {
            	map.get(child).in--;
                if (map.get(child).in == 0) {
                	que.offer(child);
                	res += child;
                }    
            }
        }
        return res.length() == allch.size() ? res : "";
	}
}
