package group.LC;

public class IsBalanced {
	
	public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(root.left== null && root.right == null)
            return true;
        //calc the height of the left and right subtree indep
        //then get the 
        return helper(root) != -1;
            
    }
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        //if(root.left != null || root.right != null)
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        if(leftHeight == -1 || rightHeight == -1)
            return -1;
        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight)+1;
    }

}
