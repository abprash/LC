package group.LC;

/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.*/
public class DeleteNode {



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

    public void deleteNode(ListNode node) {
        if(node == null)
            return;
        //we cannot access the prev node at all
        //they have mentioned that it will not be a tail node
        if(node.next != null){
            //we copy the successive node's value
            node.val = node.next.val;
            //we point node's next to next next node - otherwise its just repeated nodes
            node.next = node.next.next;
        }
        else
            node = null;
    }
}