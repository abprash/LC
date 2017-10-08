package group.LC;

 // Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  
  //correct implementation but time limit exceeded on LEETCODE
public class MergeKSortedLists {


    public ListNode mergeKLists(ListNode[] lists) {
        //take two lists and keep combining solving them like merge two sorted lists
        ListNode ans = null;
        if(lists == null || lists.length == 0)
            return null;
        for(int i=0; i<lists.length; i++){
                ans = mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null)  return l2;
        else if(l2 == null)  return l1;
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}