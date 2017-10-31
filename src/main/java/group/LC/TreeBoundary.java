package group.LC;

public class TreeBoundary {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();
        //add the root value to the ans
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        //first we will do a left boundary walk
        leftBoundary(root.left, ans);
        
        //then left leaves walk
        leaves(root.left, ans);
        //then right leaves walk
        leaves(root.right, ans);
        //then right boundary walk
        rightBoundary(root.right, ans);
        //return the obtained ans
        return ans;
    }
    
    public void leftBoundary(TreeNode root, List<Integer> ans){
        if(root == null || (root.left == null && root.right == null) )
            return;
        //we will be adding the node to ans 
        ans.add(root.val);
        //if the left child of this node is present then we invoke leftBoundary on it
        if(root.left != null)
            leftBoundary(root.left, ans);
        else //if there is no left child, we invoke this on the present right child
            leftBoundary(root.right, ans);
    }
    
    public void rightBoundary(TreeNode root, List<Integer> ans){
        if(root == null || (root.left == null && root.right == null))
            return;
        
        if(root.right  != null)
            rightBoundary(root.right, ans);
        else
            rightBoundary(root.left, ans);
        //add this node's val
        //since this is reverse
        ans.add(root.val);
    }
    
    public void leaves(TreeNode root, List<Integer> ans){
        if(root == null)
            return;
        //we will add the node to the ans only if there are no children
        if(root.left == null && root.right == null){
            ans.add(root.val);
            return;
        }
        //else we go on below
        leaves(root.left, ans);
        leaves(root.right,ans);
    }
}