package addtwonum_2;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		int cc=0; int sum=0;
		//第一次单个弄出来的原因是需要head，没办法
		sum = l1.val+l2.val;
	    if(sum>=10){
	    	cc=1;
	    	sum=sum-10;
	    }
	    l1=l1.next;
	    l2=l2.next;
	    ListNode head = new ListNode(sum);
	    ListNode tail = head;
		while(l1!=null && l2!=null){
		    sum = l1.val+l2.val+cc;
		    if(sum>=10){
		    	cc=1;
		    	sum=sum-10;
		    }
		    else{
		        cc=0;
		    }
		    ListNode temp = new ListNode(sum);
		    l1=l1.next;
		    l2=l2.next;
		    tail.next=temp;
		    tail=tail.next;
		}
        while(l1!=null){
				sum = l1.val+cc;
			    if(sum>=10){
			    	cc=1;
			    	sum=sum-10;
			    }
			    else{
			    	cc=0;
			    }
			    ListNode temp = new ListNode(sum);
			    l1=l1.next;
			    tail.next=temp;
			    tail=tail.next;
			}
        while(l2!=null){
			sum = l2.val+cc;
		    if(sum>=10){
		    	cc=1;
		    	sum=sum-10;
		    }
		    else{
		    	cc=0;
		    }
		    ListNode temp = new ListNode(sum);
		    l2=l2.next;
		    tail.next=temp;
		    tail=tail.next;
		}
        if(cc!=0){
        	ListNode temp = new ListNode(cc);
        	tail.next=temp;
        	tail=tail.next;
        }

	     return head;
    }
}
