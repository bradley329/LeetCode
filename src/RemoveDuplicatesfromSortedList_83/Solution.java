package RemoveDuplicatesfromSortedList_83;

import SinglyLinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

// Ok, the version i wrote is a general version when the list is not sorted!
/* Given a sorted linked list, delete all duplicates such that each element appear only once.

        For example,
        Given 1->1->2, return 1->2.
        Given 1->1->2->3->3, return 1->2->3.*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head.val)) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
