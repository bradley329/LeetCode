package rotateList_170;

import swapNodesinPairs_24.ListNode;
// corner case: k > len
public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
			return head;
		}
        int len = 0;
        int idx = 0;
        ListNode tailFirsthalf = null;
        ListNode tail = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null) {
        	tail = head;
        	if (tailFirsthalf == null && idx == k) {
        		tailFirsthalf = dummy.next;
			} else if (tailFirsthalf != null) {
				tailFirsthalf = tailFirsthalf.next;
			}
        	idx++;
        	head = head.next;
        }
        
        // get the len;
        len = idx;
        
        ListNode headSecond = null;
        // k < len;
        if (tailFirsthalf != null) {
        	headSecond = tailFirsthalf.next;
        	tailFirsthalf.next = null;
        	head = dummy.next;
        	dummy.next = headSecond;
        	tail.next = head;
		} else {
			// k > len;
			k = k % len;
			if (k != 0) {
				// copy the code when k < len;
				head = dummy.next;
				idx = 0;
				while (head != null) {
		        	tail = head;
		        	if (tailFirsthalf == null && idx == k) {
		        		tailFirsthalf = dummy.next;
					} else if (tailFirsthalf != null) {
						tailFirsthalf = tailFirsthalf.next;
					}
		        	idx++;
		        	head = head.next;
		        }
				headSecond = tailFirsthalf.next;
	        	tailFirsthalf.next = null;
	        	head = dummy.next;
	        	dummy.next = headSecond;
	        	tail.next = head;
			}
		}
        return dummy.next;
    }
}
