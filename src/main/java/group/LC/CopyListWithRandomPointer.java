package group.LC;

public class CopyListWithRandomPointer {

//method with O(N) space and O(N) run time
 // Definition for singly-linked list with a random pointer.
  class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };



    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        //put all of them into a hashmap
        while(cur != null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        //next copy all of the next and random values into the duplicate objects
        for(Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()){
            //we get the label of the first entry
            RandomListNode node = entry.getValue();
            //we need to fll in the next and random values so
            //we query the map for the node containing the next and the random value - so that we can point to that
            node.next = map.get(entry.getKey().next);
            node.random = map.get(entry.getKey().random);
        }
        return map.get(head);
    }
}
//************************************************
//Method with O(1) space and O(N) run time
//*******************************
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        
        //copy the nodes alone first
        RandomListNode cur = head;
        while(cur != null){
            //create a new node
            RandomListNode temp = new RandomListNode(cur.label);
            //store cur's next
            RandomListNode nextNode = cur.next;
            //make curs next point to this
            cur.next = temp;
            temp.next = nextNode;
            cur = nextNode;
        }
        
        //now copy the random pointers properly
        cur = head;
        while(cur != null){
            RandomListNode n2 = cur.next;
            if(cur.random == null)
                n2.random = null;
            else
                n2.random = cur.random.next;
            cur = cur.next.next;
        }
        
        //now detach them
        RandomListNode head2 = head.next;
        cur = head;
        RandomListNode cur2 = head2;
        while(cur != null && cur2 != null){
            //now make cur and cur2 point to their respective next elements and unlink
            cur.next = cur.next.next;
            if(cur2.next == null)
                break;
            cur2.next = cur2.next.next;
            //now pointing is done, now actually shift them
            cur = cur.next;
            cur2 = cur2.next;
        }
        return head2;
    }
}