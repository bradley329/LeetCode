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
    	//一开始分了奇偶但好像后面发现是一样的
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
    	//注意 这一开始有bug。i充当的是end 所以是exclusive的!
    	for (int i = st+1; i <= end; i++) {
			if (isPalindrome(st, i, s)) {
				intermediate.add(s.substring(st,i));
				DFShelper(i, end, s);
				intermediate.remove(intermediate.size()-1);
			}
		}
    }
}
