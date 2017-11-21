package group.LC;

public class LongestConsecutiveSequence_Tree {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        int len = 0;
        TreeNode prev = null;
        //int maxLen = 1;
        helper(root, len, root.val);
        return maxLen;
    }
    
    public void helper(TreeNode root, int len, int nextVal){
        //so we should effectively know when a sequence starts
        //so by default, we start off with 1
        //when 
        if(root == null)
            return;
        
        if(nextVal == root.val){
            //we have a consecutive sequence
            //
            
            len+=1;
            if(len > maxLen)
                maxLen = len;
            nextVal+=1;
            //System.out.println(root.val+", nextval ="+nextVal+", len ="+len+", max="+maxLen);
            helper(root.left, len, nextVal);
            helper(root.right, len, nextVal);
        }
        else{
            //reset it
            len = 1;
            nextVal = root.val+1;
            //maxLen = 1;
            helper(root.left, len, nextVal);
            helper(root.right, len, nextVal);
        }
    }
}