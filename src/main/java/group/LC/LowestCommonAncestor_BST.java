package group.LC;

public class LowestCommonAncestor_BST {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            //means that the root is bigger than both
            //so we can eliminate the right part of the tree entirely
            return lowestCommonAncestor(root.left, p, q);
        } 
        else if(root.val < p.val && root.val < q.val){
            //must be in  the right part of the tree
            return lowestCommonAncestor(root.right, p, q);
        }
        else
            return root;
    }
}