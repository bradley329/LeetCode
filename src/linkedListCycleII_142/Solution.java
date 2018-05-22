package linkedListCycleII_142;

import swapNodesinPairs_24.ListNode;

public class Solution {
	public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) return null;
        boolean findCycle = false;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast!=null && fast.next!=null) {
        	if (fast == slow) {
        		findCycle = true;
        		break;
        	}
        	slow = slow.next;
        	fast = fast.next.next;
        }
        if(!findCycle) return null;
        fast = head;
        while(fast != slow){
        	fast = fast.next;
        	slow = slow.next;
        }
        return fast;
    }
}
