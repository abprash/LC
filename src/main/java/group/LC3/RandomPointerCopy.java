package group.LC;

public class RandomPointerCopy {
	
	/*public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;
        if(head.next == null)//there is just one node in the linked list
            return head;
        RandomListNode newHead = new RandomListNode(0), p1 = head, newp1 = newHead;
        while(p1 != null){
            newp1.val = p1.val;
            if(p1.random == null){
                //simply move on to the next node
            }
            else{
                //we have to start copying that linked list too
            }
            //move on
            if(p1.next != null){
                p1 = p1.next;
                newp1.next = new RandomListNode(0);
                newp1 = newp1.next;
            }
            else{
                newp1.next = null;
            }
        }
        return newHead;
    }*/
}
