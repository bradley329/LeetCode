package reverseLinkedListII_92;

import swapNodesinPairs_24.ListNode;

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m < 1 || m >= n) {
			return head;
		}
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        int idx = 1;
        ListNode intervalPre = null;
//        ListNode intervalTail = null;
        ListNode next = null;
        while (head != null) {
        	if (idx < m) {
        		pre = head;
				head = head.next;
			} else if (idx == m) {
				intervalPre = pre;
				pre = head;
				head = head.next;
			} else if (idx < n) {
				next = head.next;
				head.next = pre;
				pre = head;
				head = next;
			} else if (idx == n) {
				next = head.next;
				head.next = pre;
//				intervalTail = next;
				ListNode intervalHead = intervalPre.next;
				intervalPre.next = head;
				intervalHead.next = next;
				break;
			}
        	idx++;
        }
        return dummy.next;
    }
}
