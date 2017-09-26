package group.LC;

/*
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find 
the kth smallest frequently? How would you optimize the kthSmallest routine?
 * 
 * 
 * 
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
public class KthSmallestInBST {
    List<Integer> counter = new ArrayList<Integer>();
    int ans = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        helperInOrderTraversal(root, k);
        return ans;
    }
    
    
    public void helperInOrderTraversal(TreeNode root, int count){
        if(root == null)
            return;
        
        if(root.left != null)
            helperInOrderTraversal(root.left, count);
        counter.add(root.val);
        if(counter.size() == count){
            ans = root.val;
            return;
        }
        //System.out.println(root.val);
        if(root.right != null)
            helperInOrderTraversal(root.right, count);
    }
}