package group.LC;

public class CountNodesInCompleteBinaryTree {

	/**************************************************
	 *TIME LIMIT EXCEEDED!!!!!!!!!!!!!!
	 *recursive way does not work!!
	 * ************************************************
	 * 
	*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *///****************************
    int count = 0;
    
    public int countNodes(TreeNode root) {
        
        if(root == null)
            return 0;
        //count++;
        //countNodes(root.left);
        //countNodes(root.right);
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    
    public static void main(String[] args){
    	System.out.println((1<<2) - 1);
    	//the minus 1 is because there is only one root
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
        public int countNodes(TreeNode root) {
           
            if(root == null)
                return 0;
            
            //calc the left and right depth
            int leftDepth = leftDepth(root);
    	    int rightDepth = rightDepth(root);
            
            if(leftDepth == rightDepth)
                return ((1 << leftDepth)-1);
            else
                return 1+countNodes(root.left)+countNodes(root.right);
            
                
        }
        
        private int rightDepth(TreeNode root) {
    	// TODO Auto-generated method stub
    	int dep = 0;
    	while (root != null) {
    		root = root.right;
    		dep++;
    	}
    	return dep;
    }

    private int leftDepth(TreeNode root) {
    	// TODO Auto-generated method stub
    	int dep = 0;
    	while (root != null) {
    		root = root.left;
    		dep++;
    	}
    	return dep;
    }
    }
}
