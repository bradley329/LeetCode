package MathWorks;

import swapNodesinPairs_24.ListNode;

public class ReverseLinkedList {
	public ListNode reverse(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode pre = null;
		while (head != null) {
			ListNode tp = head.next;
			head.next = pre;
			pre = head;
			head = tp;
		}
		return pre;
	}
}
