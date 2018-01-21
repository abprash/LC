package group.LC2;


//Much better AC solution
// So very clean
//*************************

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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        //invoke helper
        helper(root);
        return maxSum;
    }
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        //get the respective max sums from left and right subtrees
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        //now check with max
        maxSum = Math.max(maxSum, left + right + root.val);
        return root.val + Math.max(left, right); 
    }
}

//Not so good solution
//68/90 test cases passed
public class MaximumPathSumBT {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    int  max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        int sum1 = root.val + helper(root.left) + helper(root.right);
        int sum2 = maxPathSum(root.left);
        int sum3 = maxPathSum(root.right);
        int temp = Math.max(sum1, Math.max(sum2, sum3));
        if(temp > max)
            max = temp;
        return max;
    }
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        //can be either positive or negative
        if(root.left == null && root.right == null){
            //leaf node
            if(root.val >= 0)
                return root.val;
            else
                return 0; // stop at the parent itself
        }
        if(root.left == null || root.right == null){
            if(root.val >= 0){
                if(root.right != null)
                    return root.val + helper(root.right);
                else
                    return root.val +  helper(root.left);
            }
            else{
                return 0;
            }
        }
        else{
            //both children are present
            //if root val is +ve
            if(root.val >= 0)
                return root.val + Math.max(helper(root.left), helper(root.right));
            else
                return 0;
        }
    }
}