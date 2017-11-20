package group.LC;

public class MinDepthOfTree {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    int minHeight = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        helper(root, 1);
        return minHeight;
    }
    
    public void helper(TreeNode root, int height){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(height < minHeight)
                minHeight = height;
            return;
        }
        helper(root.left, height + 1);
        helper(root.right, height + 1);
    }
}