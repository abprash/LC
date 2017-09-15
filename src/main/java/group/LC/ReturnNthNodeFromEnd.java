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
	
	public static void main(String[] args){
	}

}
