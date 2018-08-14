package group.LC4;

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
}