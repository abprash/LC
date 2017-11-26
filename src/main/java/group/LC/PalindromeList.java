package group.LC;

public class PalindromeList {
//*****************************MUCH BETTER SOLUTION
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	    public boolean isPalindrome1(ListNode head) {
	        
	        //keep a fast and slow pointer
	        
	        if(head == null)
	            return true;
	        
	        ListNode slow = head, fast = head;
	        // if(slow.next != null )
	        //     fast = slow.next.next;
	        
	        while(fast != null && fast.next != null){
	            slow = slow.next;
	            //if(fast.next != null)
	            fast = fast.next.next;
	        }
	        
	        //now consider the odd numbered list
	        if(fast != null){
	            //list is odd numbered
	            slow = slow.next;
	        }
	        
	        //now fast is at the end, and slow is at the mid point
	        
	        ListNode slow1 = head;
	        slow = reverseList2(slow);
	        
	        while(slow != null && slow1 != null){
	            // start reversing it
	            if(slow.val != slow1.val)
	                return false;
	            slow = slow.next;
	            slow1 = slow1.next;
	        }
	        return true;
	        
	    }
	    
	    
	    public ListNode reverseList2(ListNode head){
	        
	        if(head == null)
	            return null;
	        
	        ListNode prev = head, cur = null, nextNode = null;
	        if(prev.next != null)
	            cur = prev.next;
	        int counter = 0;
	        while(cur != null){
	            if(counter == 0)
	                prev.next = null;
	            nextNode = cur.next;
	            //rearrange the pointers now - 
	            cur.next = prev;
	            
	            //move to the next node
	            prev = cur;
	            cur = nextNode;
	            
	            counter++;
	        }
	        
	        return prev;
	    }
	
	
	
	
	
/**************
 * 
 * Very shitty solution below
 * 
 * 
 * 
 * **************/
	
	
	
	
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        String s1 = traversal(head);
      
        ListNode rev = reverseList(head);
        String s2 = traversal(rev);
        return s1.equals(s2) ? true : false;
    }
    
    
    public String traversal(ListNode head){
        if(head == null)
            return null;
        StringBuilder sb = new StringBuilder();
        ListNode iter = head;
        while(iter != null){
            //System.out.print("->"+iter.val);
            sb.append(Integer.toString(iter.val));
            iter = iter.next;
        }
        
        return sb.toString();
    }
    
    
    public ListNode reverseList(ListNode head){
        
        if(head == null)
            return null;
        
        ListNode prev = head, cur = null, nextNode = null;
        if(prev.next != null)
            cur = prev.next;
        int counter = 0;
        while(cur != null){
            if(counter == 0)
                prev.next = null;
            nextNode = cur.next;
            //rearrange the pointers now - 
            cur.next = prev;
            
            //move to the next node
            prev = cur;
            cur = nextNode;
            
            counter++;
        }
        
        return prev;
    }
    
    public static void main(String[] args){
    	String s ="hello";
    	System.out.println(s.substring(0,0));
    }
}