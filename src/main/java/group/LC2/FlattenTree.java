package group.LC2;

public class FlattenTree {

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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode right = root.right;
        TreeNode left = root.left;
        //flatten it
        flatten(left);
        flatten(right);
        root.left = null;
        
        root.right = left;
        //assign cur to the root node
        TreeNode cur = root;
        //now keep going right ...  why?
        while(cur.right != null)
            cur = cur.right;
        //this is so that we attach the present right to the final right leaf
        cur.right = right;
    }
}