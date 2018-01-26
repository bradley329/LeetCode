package VMWareOA;

import SinglyLinkedList.ListNode;

public class DeleteEvenNode {
	public static ListNode deleteEvenNode(ListNode root) {
		if (root == null) {
			return root;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = root;
		ListNode pre = dummy;
		ListNode cur = root;
		while (cur != null) {
			if (cur.val % 2 == 0) {
				pre.next = cur.next;
				cur = pre.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return dummy.next;
	}
	
	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode root = new ListNode(4);
		ListNode one = new ListNode(1);
		root.next = one;
		ListNode two = new ListNode(2);
		one.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(5);
		three.next = four;
		print(root);
		print(deleteEvenNode(root));
	}
}
