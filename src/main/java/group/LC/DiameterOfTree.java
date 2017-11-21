package group.LC;

public class DiameterOfTree {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return 0;
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        //calc the depth of the left and right subtrees
        int left = helper(root.left);
        int right = helper(root.right);
        
        //find the sum of left and right depths, compare with max
        max = Math.max(left+right, max);
        
        //but for the node above, send our max depth
        return Math.max(left, right) + 1;
    }
    
}