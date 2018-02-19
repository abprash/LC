package group.LC3;

public class LongestConsecutiveSeqBT2 {

	//my very own solution
	//****************************
	
	
	//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/description/
	
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    
    int maxLen = Integer.MIN_VALUE;
    
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        int l1 = decr(root.left, root.val-1) + 1 + incr(root.right, root.val+1);
        int l2 = decr(root.right, root.val-1) + 1 + incr(root.left, root.val+1);
        maxLen = Math.max(maxLen, Math.max(l1,l2));
        longestConsecutive(root.left);
        longestConsecutive(root.right);
        return maxLen;
    }
    
    public int incr(TreeNode root, int val){
        if(root == null)
            return 0;
        if(root.val == val)
            return 1 + Math.max(incr(root.left, root.val+1), incr(root.right, root.val+1));
        else
            return 0;
    }
    
    public int decr(TreeNode root, int val){
        if(root == null)
            return 0;
        if(root.val == val)
            return 1 + Math.max(decr(root.left, root.val-1), decr(root.right, root.val-1));
        else
            return 0;
    }
    
    
}