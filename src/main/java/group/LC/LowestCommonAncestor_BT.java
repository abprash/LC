package group.LC;

public class LowestCommonAncestor_BT {


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
        if(root == null || root == p || root == q)
            return root;
        else{
            //lowestCommonAncestor(root.left, p, q);
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left != null &&  right != null){
                
                //means that we have reached both the nodes and they are below us - yes
                //so we are the LCA
                return root;
            }
            else{
                //one of them is null
                //which means that one of them is below the other so the non null one is the parent
                if(left == null)
                    return right;
                else
                    return left;
            }
        }
    }
}