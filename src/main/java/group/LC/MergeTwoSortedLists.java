package group.LC;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// very inefficient solution though
//sucks!!!!!!!!!!!!!!

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            if(l1 != null)
                return l1;
            else
                return l2;
        }
        //keep iter on both lists
        //find the lesser element of the heads of two lists and keep that as the ans head
        ListNode head = null;
        //iter - for the final list
        //temp 1 and temp 2 - iters for the lists l1 and l2
        ListNode temp1 = l1, temp2 = l2, iter = null;
        while(temp1!= null && temp2 != null){
            if(temp1.val < temp2.val){
                if(iter == null){
                    iter = temp1;
                    head = iter;
                }
                else{
                    iter.next = temp1;
                    iter = temp1;
                }
                temp1 = temp1.next;
            }
            else{
                if(iter == null){
                    iter = temp2;
                    head = iter;
                }
                else{
                    iter.next = temp2;
                    iter = temp2;
                }
                temp2 = temp2.next;
            }
            //iter = iter.next;
            System.out.println(iter.val);
        }
        System.out.println(head.val);
        while(temp1 == null && temp2 != null){
            iter.next = temp2;
            iter = temp2;
            temp2 = temp2.next;
        }
        while(temp2 == null && temp1 != null){
            iter.next = temp1;
            iter = temp1;
            temp1 = temp1.next;
        }
        return head;
    }
}