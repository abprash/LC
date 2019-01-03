package group.LC4_swe;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class FlipEquivalentBinaryTree {


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
        public boolean flipEquiv_better(TreeNode root1, TreeNode root2) {
            //three cases to handle
            if(root1 == null && root2 == null)
                return true;
            else if(root1 == null || root2 == null || root1.val != root2.val)
                return false;
            else{
                //they can be either flipped or unflipped
                return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
            }
        }
    }


    public boolean flipEquiv_mine(TreeNode root1, TreeNode root2) {
        // we need to find if the BTs are flip equiv or not
        //two conditions to check recursively, either the children should be equal
        // or they should be flipped, but the values should remain the same.
        //keep going as far as possible, when these conditions dont match, return false.

        if(root1 == null && root2 == null)
            return true;
        else if (root1 == null || root2 == null)
            return false;
        else{
            //can be either flipped or not
            //the roots must be of equal value
            boolean equalRoots = root1.val == root2.val;
            if (!equalRoots)
                return false;
            boolean flipped = false, notFlipped = false;
            //two cases to handle, they may be not null, and flipped/non flipped
            flipped = (root1.left != null && root2.right != null && root1.left.val == root2.right.val) || (root1.right != null && root2.left != null && root1.right.val == root2.left.val);

            notFlipped = (root1.left != null && root2.left != null && root1.left.val == root2.left.val) || (root1.right != null && root2.right != null && root1.right.val == root2.right.val);
            // or they can be null and flipped
            boolean notFlippedNull = (root1.left == null && root2.left == null)&& (root1.right == null && root2.right == null);
            boolean nullFlipped  = (root1.left == null && root2.right == null) && (root1.right == null && root2.left == null);

            //if null, no need to go further down
            if(nullFlipped || notFlippedNull)
                return true;
            else if(notFlipped)
                return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            else if(flipped)
                return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            else
                return false;
        }
    }

}