package group.LC2;

public class SecondMinNode {

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
    int min = Integer.MAX_VALUE-1, min2 = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return 0;
        helper(root);
        return (min2 == Integer.MAX_VALUE) ? -1 : min2;
    }
    
    public void helper(TreeNode root){
        if(root == null)
            return;
        if(root.val < min )
            min = root.val;
        if(root.val > min && root.val < min2)
            min2 = root.val;
        helper(root.left);
        helper(root.right);
    }
    
}