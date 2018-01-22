package group.LC2;

public class InorderSuccessor {

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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
            return null;
        if(root.val <= p.val){
            //the root value is smaller than p, so we have to go right
            return inorderSuccessor(root.right, p);
        }
        else{
            //root value is bigger, so go left now
            TreeNode left = inorderSuccessor(root.left, p);
            if(left != null)
                return left;
            else
                return root;
        }
    }
}