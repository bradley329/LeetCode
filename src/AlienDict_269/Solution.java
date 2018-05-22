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
		//set��ʵû��Ҫ��
		Set<Character> allch = new HashSet<>();
		Map<Character, AlienChar> map = new HashMap<>();
		int n = words.length;
		//���г��ֵ�char������map
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
					//���ӹ�ϵ����ȫ�����ظ��ģ���
					if (map.get(words[i].charAt(j)).next.add(words[i+1].charAt(j))) {
						map.get(words[i+1].charAt(j)).in++;
					}
					//break��ԭ���Ǻ��沢����lexical order
					break;
				}
				//�����ж���ʵ��input����в�����lexical�ģ���wrt & wr��Ӧ����wr��ǰ
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
