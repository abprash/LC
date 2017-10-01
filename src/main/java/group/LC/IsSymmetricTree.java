package group.LC;




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class IsSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left== null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return helper(left.left,right.right) && helper(left.right, right.left);
    }
    
    public static void main(String[] args){
    	if(Character.isDigit('d'));
    	int x = Integer.parseInt("000");
    	System.out.println(x);
    }
}