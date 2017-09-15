package group.LC;

public class AddTwoNumbers_1 {
	
	public static void main(String[] args){
		
	}
	
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //keep two pointers
        //keep going in the long one until you reach identical positions
        //
        ListNode p1 = null, p2 = null;
        if(l2==null)
            return l1;
        if(l1 == null)
            return l2;
        p1 = l1;
        p2 = l2;
        int carry = 0;
        int sum = 0;
        ListNode head = new ListNode(0);
        ListNode p3 = head;
        while(p1 != null || p2 != null){
            
            //calc the sum
            sum = carry;
            
            if(p1 != null){
                //dont do anything
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                //dont do anything
                sum += p2.val;
                p2 = p2.next;
            }
            if(sum >= 10){
                carry = 1;
                sum = sum%10;
            }
            else{
                carry = 0;
            }
            p3.val = sum;
            //we have already shifted to the next digit
            if(p1 != null || p2 != null || carry > 0){
                
                ListNode temp = null;
                if(carry == 0)
                    temp = new ListNode(0);
                if(carry > 0 )
                    temp = new ListNode(carry);
                p3.next = temp;
                p3 = temp;
            }
            
        }
        return head;
    }
	
	
}
