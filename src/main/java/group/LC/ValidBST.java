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
public class ValidBST {
	
	//****************69/74 cases
/*    public boolean isValidBST(TreeNode root) {
        if(root != null){
            System.out.print(root.val+", ");
            if(root.left != null && root.right != null)
                return (root.left.val < root.right.val && root.val < root.right.val && root.left.val < root.val)?isValidBST(root.left) && isValidBST(root.right):false;
            if(root.left != null)
                return  root.left.val < root.val?isValidBST(root.left):false;
            if(root.right != null)
                return  root.right.val > root.val?isValidBST(root.right):false;
        }
        return true;
    }*/
	//******************
	public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    public boolean helper(TreeNode root, Integer min, Integer max){
         if(root == null)
             return true;
        if((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;           
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}