package group.LC;

public class MergeTrees {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return null;
        if(t1 == null || t2 == null){
            if(t1 == null)
                return t2;
            else
                return t1;
        }
        //both are not null
        TreeNode newRoot = new TreeNode(t1.val + t2.val);
        newRoot.left = mergeTrees(t1.left, t2.left);
        newRoot.right = mergeTrees(t1.right, t2.right);
        return newRoot;
    }
    
    public static void main(String[] args){
    	double minDif = Double.MAX_VALUE;
    }
}