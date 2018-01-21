package group.LC2;

public class RecoverBST {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    TreeNode n1 = null, n2 = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    
    public void recoverTree(TreeNode root) {
        //we will traverse the tree
        //wherever the BST order fails, we mark them and swap them
        if(root == null)
            return;
        helper(root);
        
        //swap n2 and n3 val
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
        return;
    }
    
    public void helper(TreeNode root){
        if(root == null)
            return;
        //we are simply doing an inorder traversal and maintaining the order of the 3 nodes
        //left
        //current
        //right
        helper(root.left);
        
        if(n1 == null && prev.val >= root.val)
            n1 = prev;
        
        if(n1 != null && prev.val >= root.val)
            n2 = root;
        prev = root;
        helper(root.right);
    }
}