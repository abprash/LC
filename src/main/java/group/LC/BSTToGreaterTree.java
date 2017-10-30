package group.LC;

public class BSTToGreaterTree {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return null;
        //its not null
        //now we have to add nos greater than it
        //its left child is always lesser, so that will be the greatest node ever
        //root.left = root;
        helperCalculateSum(root);
        return root;
    }
    
    public void helperCalculateSum(TreeNode root){
       //do a rev inorder traversal
        if(root == null)
            return;
        helperCalculateSum(root.right);
        sum +=root.val;
        root.val = sum;
        helperCalculateSum(root.left);
        return;
    }
}
