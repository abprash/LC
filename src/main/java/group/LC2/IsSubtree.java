package group.LC2;

public class IsSubtree {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

	
	//reference
	//https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/
		
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(helper(s, t))
            return true;
        else
            return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean helper(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.val != t.val)
            return false;
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}