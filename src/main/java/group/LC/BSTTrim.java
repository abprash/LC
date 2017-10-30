package group.LC;

public class BSTTrim {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return root;
        if(root.val <= R && root.val >= L){
            //its valid
            //do nothing
            //check its children now
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
        else{
            //we should eliminate one half of its children
            if(root.val < L){
                //entire left subtree is invalid
                root.left = null;
                root = trimBST(root.right,L,R);
            }
            else if(root.val > R){
                //entire right sub tree is invalid
                root.right = null;
                root = trimBST(root.left,L,R);
            }
            return root;
        }
    }
}