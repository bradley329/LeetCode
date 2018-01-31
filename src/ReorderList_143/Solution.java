package ReorderList_143;

import SinglyLinkedList.ListNode;

public class Solution {
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode next = mid.next;
        mid.next = null; // break the list in the middle!
        ListNode tail = reverse(next); // reverse the order of right half listnodes
        merge(head, tail); // then all we have to do is merge two list!
    }
	
	private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    private void merge(ListNode head1, ListNode head2) {
        // this is the version where we don't use a dummy node
        while (head1 != null && head2 != null) {
            ListNode next = head1.next;
            head1.next = head2;
            head2 = head2.next;
            head1.next.next = next;
            head1 = next;
        }
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
