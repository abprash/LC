package group.LC2;

public class SumRootToLeafNos {

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
    int res = 0;
    
    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return res;
    }
    
    public void dfs(TreeNode root, String s){
        if(root == null)
            return;
        s += root.val;
        if(root.left == null && root.right == null){
            res += Integer.parseInt(s);
            return;
        }
        dfs(root.left, s);
        dfs(root.right, s);
    } 
}