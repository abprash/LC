package group.LC2;

public class LinkedListCycle2 {

}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        //slow and fast pointers
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            //move first
            slow = slow.next;
            fast = fast.next.next;
            //then check
            if(slow == fast){ 
                //have another slow start from the head, and this time return when these two meet
                ListNode slow2 = head;
                while(slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
            
        }
        return null;
    }
}