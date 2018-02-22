package group.LC;

public class ReturnNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        //we initially keep two pointers
        //runner and walker
        //runner is placed init n nodes away from walker
        //when runner reaches the end
        //return walker.val
        
        if(head == null)
            return head;
        //assuming n < length of linked list
        ListNode walker = head;
        ListNode runner = head;
        for(int i=0; i<n; i++){
            if(runner != null)
                runner = runner.next;
        }
        while(runner != null){
            walker = walker.next;
            runner = runner.next;
        }
        System.out.println(walker.val);
        return walker;
        
    }
	public ListNode removeNthFromEnd(ListNode head, int n) {
        //we initially keep two pointers
        //runner and walker
        //runner is placed init n nodes away from walker
        //when runner reaches the end
        //return walker.val
        
        if(head == null)
            return head;
        //assuming n < length of linked list
        ListNode walker = head;
        ListNode runner = head;
        for(int i=0; i<n; i++){
            if(runner != null)
                runner = runner.next;
        }
        if(runner == null && n == 1)
            return null;
        if(runner != null){
            while(runner.next != null){
                walker = walker.next;
                runner = runner.next;
            }
        }
        else{
            //it means runner is null
            return walker.next;
        }
        ListNode temp = walker.next;
        walker.next = temp.next;
        System.out.println(walker.val);
        return head;
        
    }
	public static void main(String[] args){
	}
	
	//the below implementation does not work
	//*******************************************************************************************
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        //reverse list 1 and list 2 and calc sum
	        if(l1 == null)
	            return l2;
	        if(l2 == null)
	            return l1;
	        ListNode p1 = l1;
	        ListNode p2 = l2;
	        ListNode head = new ListNode(0);
	        ListNode head1 = head;
	        // ListNode r1 = reverseList(l1);
	        // ListNode r2 = reverseList(l2);
	        // ListNode revResult = addTwoNumbers2(r1, r2);
	        // return reverseList(revResult);
	        //calc the length of l1 and l2
	        int len1 = lengthOfList(l1);
	        int len2 = lengthOfList(l2);
	        int small = 0, big = 0;
	        ListNode bigList = null;
	        ListNode smallList = null;
	        if(len1 > len2){
	            small = len2;
	            big = len1;
	            bigList = l1;
	            smallList = l2;
	        }else if(len1 < len2){
	            small = len1;
	            big = len2;
	            bigList = l2;
	            smallList = l1;
	        }
	        System.out.println(len1+","+len2);
	        //find the big and small list
	        int i=0, j=0;
	        while(p1 != null || p2!= null){
	            if(small == 0 && big == 0){
	                //same len for both lists
	                head.val = p1.val + p2.val;
	                ListNode temp = new ListNode(0);
	                head.next = temp;
	                head = temp;
	               
	            }
	            else{
	                if(big <= small){
	                    head.val+=smallList.val;
	                    smallList = smallList.next;
	                    small--;
	                }
	                head.val += bigList.val;
	                ListNode temp = null;
	                if(bigList.next != null){
	                    temp = new ListNode(0);
	                }else{
	                    //nothing .. must be null
	                }
	                head.next = temp;
	                head = temp;
	                bigList = bigList.next;
	                big--;
	            }
	            if(p1 != null)
	                p1 = p1.next;
	            if(p2 != null)
	                p2 = p2.next;
	        }
	        return reverseListAndHandleCarry(head1);
	        
	    }
	    
	    public int lengthOfList(ListNode l1){
	        if(l1 == null)
	            return 0;
	        int count = 0;
	        while(l1 != null){
	            count++;
	            l1 = l1.next;
	        }
	        return count;
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
	    
	    public ListNode reverseListAndHandleCarry(ListNode l1){
	         if(l1 == null)
	            return l1;
	        ListNode head = l1;
	        ListNode p1 = l1;
	        ListNode p2 = null;
	        if(p1 != null)
	            p2 = p1.next;
	        int i=0;
	        int sum = 0, carry=0;
	        while(p2 != null){
	            if(i == 0)
	                p1.next = null;
	            if(p2.val >= 10){
	                if(p2.val >=10)
	                    carry = p2.val % 10;
	                else
	                    carry = 0;
	                p2.val += sum + (p2.val / 10);
	                p1.val += carry;

	                ListNode temp = p2.next;
	                if(p2.next == null){
	                    p2.next = p1;
	                    return p2;
	                }
	            }
	            //or else simply
	            //reverse it
	            p2.next = p1;
	            p1 = p2;
	            p2 = temp;
	            i++;
	        }
	        return p1;
	    }
	    
//	     public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
//	         //keep two pointers
//	         //keep going in the long one until you reach identical positions
//	         //
//	         ListNode p1 = null, p2 = null;
//	         if(l2==null)
//	             return l1;
//	         if(l1 == null)
//	             return l2;
//	         p1 = l1;
//	         p2 = l2;
//	         int carry = 0;
//	         int sum = 0;
//	         ListNode head = new ListNode(0);
//	         ListNode p3 = head;
//	         while(p1 != null || p2 != null){
	            
//	             //add the carry
//	             sum = carry;
	            
//	             //add p1 value
//	             if(p1 != null){
//	                 //if p1 is null ignore
//	                 //dont do anything
//	                 sum += p1.val;
//	                 p1 = p1.next;
//	             }
//	             //add p2 value if not null
//	             if(p2 != null){
//	                 //dont do anything
//	                 sum += p2.val;
//	                 p2 = p2.next;
//	             }
	            
//	             //if sum >= 10, calc the sum and carry properly
//	             if(sum >= 10){
//	                 carry = 1;
//	                 sum = sum%10;
//	             }
//	             else{
//	                 carry = 0;
//	             }
	            
//	             //join with the new list
//	             p3.val = sum;
	            
//	             //we have already shifted to the next digit
//	             if(p1 != null || p2 != null || carry > 0){
	                
//	                 ListNode temp = null;
//	                 if(carry == 0)
//	                     temp = new ListNode(0);
//	                 if(carry > 0 )
//	                     temp = new ListNode(carry);
//	                 p3.next = temp;
//	                 p3 = temp;
//	             }
	            
//	         }
//	         return head;
//	     }
	//*******************************************************************************************

}
