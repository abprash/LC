package group.LC2;

public class LongestUnivaluePath {

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
    int length = 0;
    int common = 0;
    
    //we have to account for V shaped paths also,
    
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        helper(root.val, root);
        return length;
    }
    public int helper(int past, TreeNode root){
        //this function will return a non zero number only if the root val == left val, and /or root == right val
        if(root == null)
            return 0;
        //length of the left and right arms
        //will be +ve only if all elements are equal
        int left = helper(root.val, root.left);
        int right = helper(root.val, root.right);
        length = Math.max(length, left + right);
        if(root.val == past)
            return Math.max(left, right) + 1;
        return 0;
    }
}