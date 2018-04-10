package SortList_138;

import SinglyLinkedList.ListNode;

// o(n) space, o(nlogn) time
public class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    // split the linkedlist to two parts;
    // slow is the starting point in the right part.
    ListNode fast = head, slow = head, pre = null;
    // pre points to the one before slow;
    // which should be null if slow found;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    pre.next = null;
    // Conquer(sort) and merge
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);
    return merge(l1, l2);
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    if (l1.val < l2.val) {
      l1.next = merge(l1.next, l2);
      return l1;
    } else {
      l2.next = merge(l1, l2.next);
      return l2;
    }
  }
}
