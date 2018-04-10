package OddEvenLinkedList_328;

import SinglyLinkedList.ListNode;

public class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode oddTail = head;
    ListNode evenHead = head.next;
    ListNode evenTail = evenHead;
    while (evenTail.next != null) {
      oddTail.next = evenTail.next;
      oddTail = oddTail.next;
      if (oddTail.next == null) {
        evenTail.next = null;
        break;
      } else {
        evenTail.next = oddTail.next;
        evenTail = evenTail.next;
      }
    }
    oddTail.next = evenHead;
    return head;
  }
}
