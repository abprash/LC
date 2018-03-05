package group.LC;

public class ConvertSortedArrayToBST {



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        if(nums.length == 1)
            return new TreeNode(nums[0]);
        
        //basically we need to do something like a binary cutting
        int low = 0;
        int high = nums.length - 1;
        //int mid = (low+high)/2;
        //TreeNode root = new TreeNode(nums[mid]);
        TreeNode ans = helper(low,high,nums);
        return ans;
    }
    
    public TreeNode helper(int low, int high, int[] nums){
        //we need to compute the mid again and invoke the function on two diff subparts
        //we need to validate low and high
        if(low < high){
        	
            //int mid = (low+high)/2;
            
        	//to prevent overflows - always calc mid like below
        	int mid = high - (high - low)/2;
            TreeNode newNode = new TreeNode(nums[mid]);
            if(low == mid-1){
                //nothing
                //as mid has already been assigned
                newNode.left = new TreeNode(nums[low]);
            }
            else
                newNode.left = helper(low, mid-1, nums);
            if(high == (mid+1))
                newNode.right = new TreeNode(nums[mid+1]);
            else
                newNode.right = helper(mid+1,high,nums);
            return newNode;
        }
        else
            return null;
        
    }
}
