package group.LC2;

public class TwoSum4 {

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
    public boolean findTarget(TreeNode root, int k) {
        
        //things to note
        //given is a BST - take advantage of it
        
    	//Ref
    	//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/106059
    	
    	
        return search(root, root, k);
    }
    
    public boolean search(TreeNode r1, TreeNode r2, int k){
        if(r2 == null)
            return false;
        //we subtract once, and search throughout
        //we also need to consider all other children, so OR further calls to search
        return helper(r1, r2, k-r2.val) || search(r1, r2.left, k) ||  search(r1, r2.right, k);
    }
    
    public boolean helper(TreeNode r1, TreeNode r2, int k){
        if(r1 == null)
            return false;
        return (r1.val == k) && (r1 != r2) || (r1.val < k) && helper(r1.right, r2, k) || (r1.val > k) && helper(r1.left, r2, k);
    }
}

