package partitionList_86;

import swapNodesinPairs_24.ListNode;

class Solution {
    public ListNode partition(ListNode head, int x) {
    	if (head == null || head.next == null) {
			return head;
		}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastSmaller = dummy;
        ListNode pre = dummy;
        ListNode next = null;
        while (head != null) {
    		next = head.next;
        	if (head.val < x) {
        		if (lastSmaller.next != head) {
        			ListNode tp = lastSmaller.next;
    				lastSmaller.next = head;
    				head.next = tp;
    				pre.next = next; // pre does not change
        		} else {
        			pre = head;
        		}
        		lastSmaller = head;
        	} else {
        		// only change pre!
				pre = head;
			}
        	head = next;
        }
        return dummy.next;
    }
}