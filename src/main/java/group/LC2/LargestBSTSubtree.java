package group.LC2;

public class LargestBSTSubtree {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    int count = 0, max= 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(isValid(root, null, null))
            return count(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    public int count(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return count(root.left) + count(root.right) + 1;
    }
    
    public boolean isValid(TreeNode root, Integer min, Integer max){
        if(root == null)
            return true;
        if(min != null && min >= root.val)
            return false;
        if(max != null && max <= root.val)
            return false;
        else
            return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
    
    
    
    
}