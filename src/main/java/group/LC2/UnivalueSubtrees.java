package group.LC2;

public class UnivalueSubtrees {

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null)
            return 0;
        count = 0;
        helper(root);
        return count;
        
    }
    
    public boolean helper(TreeNode root){
        if(root == null)
            return true;
        
        //go further down
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        
        //now check the equality or if its a leaf
        if(left && right 
           && (root.left == null || root.left.val == root.val) 
           && (root.right == null || root.right.val == root.val)){
           count++;
           return true;
        }
        
        return false;
    }
}