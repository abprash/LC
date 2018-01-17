package group.LC2;

public class InorderPostorderTree {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //postorder's last node is the root always the root
        
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0)
            return null;
        //inStart, inEnd, postEnd, inorder and postorder
        return helper(inorder, inorder.length-1, 0, postorder, postorder.length-1 );
    }
    
    
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd){
        //inEnd is in the extreme left and inStart is in the extreme right
        if (postEnd < 0 || inStart < inEnd)
            return null;

        //The last element in postorder is the root.
        TreeNode root = new TreeNode(postorder[postEnd]);

        //find the index of the root from inorder. Iterating from the end.
        int rIndex = inStart;
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == postorder[postEnd]) {
                rIndex = i;
                break;
            }
        }
        
        //build right and left subtrees. Again, scanning from the end to find the sections.
        root.left = helper(inorder, rIndex - 1, inEnd, postorder, postEnd - (inStart - rIndex) -1);
        root.right = helper(inorder, inStart, rIndex + 1, postorder, postEnd-1);

        return root;
    }
}