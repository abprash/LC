package group.LC;

public class InvertBinaryTree {
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
	//the logic is just try on a simple 3 node problem
	//then just recursively do it for every other node
	//the rule is - solve for root, left and right first
	//then go on to solve for the others
	
	
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        
        //*********************************************
        //for a 3 node tree
        //TreeNode temp = root.right;
        //root.right = root.left;
        //root.left  = temp;
        //return root;
        //*********************************************
        
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}