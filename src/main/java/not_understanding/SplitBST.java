package not_understanding;

//https://leetcode.com/problems/split-bst/description/

public class SplitBST {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if(root == null)
            return res;
        if(root.val <= V){
            res[0] = root;
            //split the right one
            TreeNode[] rightSplit = splitBST(root.right, V);
            root.right = rightSplit[0];
            res[1] = rightSplit[1];
        }
        else{
            res[1] = root;
            //split the left subtree
            TreeNode[] leftSplit = splitBST(root.left, V);
            root.left = leftSplit[1];
            res[0] = leftSplit[0];
        }
        return res;
        
    }
    
    /////////////////////////////////
    
    
    public TreeNode splitBST2(TreeNode root, int V){
    	TreeNode[] res = new TreeNode[2];
    	if(root == null){
    		return res;
    	}
    	if(root.val <= V){
    		res[0] = root;
    		//split in the right
    		TreeNode[] temp = splitBST2(root.right, V);
    		root.right = temp[0];
    		res[1] = temp[1];
    	}
    	else{
    		//we will go left
    		//so, the second element in res will be greater
    		res[1] = root;
    		TreeNode[] temp = splitBST2(root.left, V);
    		root.left = temp[1];
    		res[0] = temp[0];
    	}
    	return res;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}