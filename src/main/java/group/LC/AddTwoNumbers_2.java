package group.LC;

public class AddTwoNumbers_2 {
	
	public static void main(String[] args){
		
	}
	//this method modifies the lists
	//if it doesn't modify probably we should change the implementation
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //reverse list 1 and list 2 and calc sum
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
        ListNode r1 = reverseList(l1);
        ListNode r2 = reverseList(l2);
        ListNode revResult = addTwoNumbers2(r1, r2);
        return reverseList(revResult);
    }
    
    public ListNode reverseList(ListNode l1){
        //check the obtained list
        if(l1 == null)
            return l1;
        ListNode head = l1;
        ListNode p1 = l1;
        ListNode p2 = null;
        if(p1 != null)
            p2 = p1.next;
        int i=0;
        while(p2 != null){
            if(i == 0)
                p1.next = null;
            ListNode temp = p2.next;
            if(p2.next == null){
                p2.next = p1;
                return p2; 
            }
            //reverse it
            p2.next = p1;
            p1 = p2;
            p2 = temp;
            i++;
        }
        return p1;
    }
    
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
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
            
            //add the carry
            sum = carry;
            
            //add p1 value
            if(p1 != null){
                //if p1 is null ignore
                //dont do anything
                sum += p1.val;
                p1 = p1.next;
            }
            //add p2 value if not null
            if(p2 != null){
                //dont do anything
                sum += p2.val;
                p2 = p2.next;
            }
            
            //if sum >= 10, calc the sum and carry properly
            if(sum >= 10){
                carry = 1;
                sum = sum%10;
            }
            else{
                carry = 0;
            }
            
            //join with the new list
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
