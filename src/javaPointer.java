
class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
}

public class javaPointer {
	
	public static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val);
			System.out.print("->");
			node = node.next;
		}
		System.out.println("null");
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		ListNode dummy = new ListNode(0);
		dummy.next = node1;
		ListNode head = node1;
		print(head);
		print(dummy.next);
		node1 = node2;
		print(head);
		print(dummy.next);
	}
}
