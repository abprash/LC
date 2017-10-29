package group.LC;

public class MaxDepth {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        //find the depth of the left sub tree
        //int leftDepth = 1 + maxDepth(root.left);
        
        
        //find depth of the right sub tree
        //int rightDepth = 1 + maxDepth(root.right);
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}