package reverseNodesin_kGroup_25;

import swapNodesinPairs_24.ListNode;

//�ҵ��뷨��reverseK������ô���£����ǲ���n1.next = nkplus;
//������������reverseK����һ����
public class LintSolution {
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        while (true) {
            head = reverseK(head, k);
            if (head == null) {
                break;
            }
        }
        
        return dummy.next;
    }
    
    // head -> n1 -> n2 ... nk -> nk+1
    // =>
    // head -> nk -> nk-1 .. n1 -> nk+1
    // return n1
    public ListNode reverseK(ListNode head, int k) {
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            if (nk == null) {
                return null;
            }
            nk = nk.next;
        }
        
        if (nk == null) return null;
        
        // reverse        
        ListNode n1 = head.next;
        ListNode nkplus = nk.next; 
        
        ListNode prev = null;
        ListNode curt = n1;
        while (curt != nkplus) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        // connect
        head.next = nk;
        n1.next = nkplus; // ����ط���û��ô�򵥡�����
        // if number of left nodes < k, then n1.next = nkplus;
        // if not, it is like what I have thought, n1.next (next head.next) will be changed to the next nk
        return n1;
    }	
}
