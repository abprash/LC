package group.LC;

public class ClosestBinarySearchValue {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    
    int ans = Integer.MAX_VALUE;
    double minVal = Double.MAX_VALUE;
    //
/*
 *another implementation way is to have a helper function to keep track of the element and min diff
*/    
    
    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return 0;
        double diff = (double) Math.abs(target - root.val);
        if(diff < minVal){
            ans = root.val;
            minVal = diff;
        }
        System.out.println(diff+",-->"+root.val);
        closestValue(root.left, target);
        closestValue(root.right, target);
        return ans;
    }
}