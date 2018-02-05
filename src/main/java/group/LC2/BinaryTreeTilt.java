package group.LC2;

public class BinaryTreeTilt {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    int res = 0;
    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        helper(root);
        return res;
        
    }
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int diff = Math.abs(right - left);
        res += diff;
        return left + right + root.val;
    }
}