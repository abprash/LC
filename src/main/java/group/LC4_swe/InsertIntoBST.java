package group.LC4_swe;

public class InsertIntoBST {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public TreeNode insertIntoBST(TreeNode root, int val) {
        insert(root, val);
        return root;
    }

    public TreeNode insert(TreeNode root, int val){
        if(root == null){
            //we have reached the correct position to insert the node, simply create the node and return
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        else{
            //we still have not reached the right place, so we need to keep going down
            // depending on the value, we go either left or right
            if(root.val < val){
                //go right
                //since the
                root.right = insert(root.right, val);
            }
            else{
                root.left = insert(root.left, val);
            }
            return root;
        }
    }
}