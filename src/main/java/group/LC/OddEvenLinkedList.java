package group.LC;

/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...


 * 
 * 
*/public class OddEvenLinkedList {
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

    public ListNode oddEvenList(ListNode head) {
        //basically make every node point its alternate node and we are good
        //initial validation
        if(head == null)
            return head;
        ListNode h1 = head, h2 = null;
        if(head.next != null)
            h2 = head.next;
        else
            return head;//there is only one element in the list
        ListNode i1 = h1, i2 = h2;
        while(i1 != null && i2 != null){
                i1.next = i2.next;
                if(i1.next != null)
                    i2.next = i1.next.next;
                else
                    i2.next = null;
                i1 = i1.next;
                i2 = i2.next;
        }
        
        //we are traversing again to get to the last node
        //we should either keep a prev node and keep track of it
        //else another traversal
        i1 = h1;
        while(i1.next != null){
            i1 = i1.next;
        }
        i1.next = h2;
        //System.out.println(h2.val);
        
        return h1;
        
    }
}