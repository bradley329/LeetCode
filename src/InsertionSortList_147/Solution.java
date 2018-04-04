package InsertionSortList_147;

import SinglyLinkedList.ListNode;

public class Solution {
  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode cur = head.next;
    head.next = null; // already sorted
    while (cur != null) {
      ListNode pre = dummy;
      head = pre.next;
      while (head != null && head.val <= cur.val) {
        pre = head;
        head = head.next;
      }
      ListNode temp = cur.next;
      cur.next = head;
      pre.next = cur;
      cur = temp;
    }
    return dummy.next;
  }
}
