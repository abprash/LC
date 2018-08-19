package group.LC4;

//https://leetcode.com/problems/linked-list-components/description/
public class LinkedListComponent {

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

    public int numComponents(ListNode head, int[] G) {
        if(head == null || G == null || G.length == 0)
            return 0;
        ListNode temp = head;
        Map<Integer, Integer> map = new HashMap<>();
        while(temp != null && temp.next != null){
            map.put(temp.val, temp.next.val);
            temp = temp.next;
        }
        // System.out.println(map);
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<G.length; i++)
            set.add(G[i]);
        temp = head;
        int ans = 0;
        while(temp != null){
            if(set.contains(temp.val)){
                //keep going in the linked list, and also keep the count constant
                while(temp != null && set.contains(temp.val)){
                    temp = temp.next;
                }
                ans++;
            }
            else{
                // ans++;//this is the sole connected node
            }
            if(temp != null)
                temp = temp.next;
        }
        return ans;
    }
}