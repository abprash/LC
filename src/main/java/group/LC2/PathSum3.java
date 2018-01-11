package group.LC2;

public class PathSum3 {

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
    public int pathSum(TreeNode root, int sum) {
        //since we need to find number of nodes adding up to sum
        //no restrictions there either
        //so we have to check every node - no option
        
        if(root == null)
            return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int dfs(TreeNode root, int sum){
        int res = 0;
        if(root == null)
            return 0;
        //if this is where the sum becomes 0, incr the count and keep going down
        if(sum - root.val == 0)
            res++;
        //recurse down anyway and add the results
        res += dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
        return res;
    }
}