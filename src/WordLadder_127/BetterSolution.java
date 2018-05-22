package wordLadder_127;

import java.util.*;

public class BetterSolution {
	public int ladderLength(String start, String end, List<String> wordList) {   
		Set<String> words = new HashSet<>();
        words.addAll(wordList);
        if (!words.remove(end)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        int res = 1, len = start.length();
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            res++;
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            //û��queue���ԭ�������ﲻ����ͬһ��֮�����ҵ�˳��
            //Set��ʹ�������Ҳ��û�����
            Set<String> next = new HashSet<>();
            for (String s : beginSet) {
                char[] ch = s.toCharArray();
                for (int i = 0; i < len; i++) {
                    char real = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String str = String.valueOf(ch);
                        if (endSet.contains(str)) {
                            return res;
                        }
                        if (words.contains(str)) {
                            next.add(str);
                            //���remove�ܾ���
                            words.remove(str);
                        }
                    }
                    ch[i] = real;
                }
            }
            beginSet = next;
        }
        return 0;
    }
}
