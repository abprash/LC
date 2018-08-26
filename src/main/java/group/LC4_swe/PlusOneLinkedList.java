package group.LC4_swe;

//https://leetcode.com/problems/plus-one-linked-list/description/

public class PlusOneLinkedList {

	/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

    public ListNode plusOne(ListNode head) {
        //reverse the linked list
        //add one to the head
        //then finish addition
        //reverse it back and return
        
        if(head == null)
            return head;
        head = reverse(head);
        int carry = 1;
        ListNode prev = head, temp = head;
        while(carry != 0){
            if(temp == null){
                prev.next = new ListNode(carry);
                break;
            }
            else{
                int sum = temp.val + carry;
                if(sum >= 10){
                    carry = 1;
                    temp.val = 0;
                }else{
                    temp.val = sum;
                    carry = 0;
                }
            }
            prev = temp;
            temp = temp.next;
        }
        head = reverse(head);
        return head;
    }
    
    public void print(ListNode head){
        while(head != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println();
    }
    
    public ListNode reverse(ListNode head){
        if(head == null)
            return head;
        ListNode prev = head, curr = head.next;
        head.next = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}