package palindromepartitioning_131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<List<String>> res = new ArrayList<>();
	private List<String> intermediate = new ArrayList<>();
    public List<List<String>> partition(String s) {   	
    	if (s == null) {
			return res;
		}
    	if (s.length() == 1) {
    		intermediate.add(s);
			res.add(intermediate);
			return res;
		}
    	int len = s.length();
    	DFShelper(0,len,s); //end is exclusive
    	return res;
    }
    
    private boolean isPalindrome(int st, int end, String s) {
    	//һ��ʼ������ż��������淢����һ����
    	int mid = st+(end-st)/2;
		for (int i = st; i < mid; i++) {
			if (s.charAt(i)!=s.charAt((end-1)-(i-st))) {
				return false;
			}
		}
    	return true;
    }
    
    private void DFShelper(int st, int end, String s) {
    	if (end == st) {
			res.add(new ArrayList<>(intermediate));
		}
    	//ע�� ��һ��ʼ��bug��i�䵱����end ������exclusive��!
    	for (int i = st+1; i <= end; i++) {
			if (isPalindrome(st, i, s)) {
				intermediate.add(s.substring(st,i));
				DFShelper(i, end, s);
				intermediate.remove(intermediate.size()-1);
			}
		}
    }
}
