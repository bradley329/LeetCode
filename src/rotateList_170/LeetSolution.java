package rotateList_170;

import swapNodesinPairs_24.ListNode;

public class LeetSolution {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode ptr = head;
        int count = 1;
        for (; ptr.next != null; count++) {
            ptr = ptr.next;
        }
        k = k % count;
        if (k == 0) {
			return head;
		}

        ListNode slow = head;
        ListNode fast = head;
        for (; fast.next != null; k--) {
            fast = fast.next;
            if (k <= 0) {
                slow = slow.next;
            }
        }
        final ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
	}
}
