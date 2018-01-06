package group.LC2;

public class SortedList2BST {

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        //lets find the middle node using fast and slow pointers
        ListNode fast = head, slow = head, prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        //assign the root
        TreeNode root = new TreeNode(slow.val);
        
        //now we need to break the list into 2 halves so that we dont recurse forever
        if(prev != null)
            prev.next = null;
        else
            head = null;
        
        //now slow points to the middle element
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}