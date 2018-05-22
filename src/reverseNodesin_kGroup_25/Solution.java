package reverseNodesin_kGroup_25;

import java.util.ArrayList;
import java.util.List;

import swapNodesinPairs_24.ListNode;

// this solution does not use constant memory
// this solution is too complicated
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 1) {
			return head;
		}
        ListNode dummy = new ListNode(0);
        List<ListNode> headList = new ArrayList<>();
    	int i = 0;
    	ListNode can = null; // head candidate
        while (head != null) {
        	if (i == 0) {
				can = head;
			}
        	i++;
        	if (i == k) {
        		headList.add(can);
				i = 0;
			}
        	head = head.next;
        }
       
        dummy.next = reverseList(headList.get(0), k);
        ListNode prev = headList.get(0);
        for (int j=1; j<headList.size(); j++) {
        	prev.next = reverseList(headList.get(j), k);
        	prev = headList.get(j);
        }
        return dummy.next;
    }
	
	public ListNode reverseList(ListNode head, int k) {
        if(head==null || head.next==null) {
			return head;
		}
		ListNode pre = null;
		int i = 0;
        while(i != k) {       	
        	ListNode tp = head.next;
        	head.next = pre;
        	pre = head;
        	head = tp;
        	i++;
        }
        return pre;
    }
}
