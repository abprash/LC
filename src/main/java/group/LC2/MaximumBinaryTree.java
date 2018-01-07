package group.LC2;

public class MaximumBinaryTree {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

	//BEAUTIFUL SOLUTIONNNNNNNNNNN!!!!!!!!!!!!!!!!!
	
	
	
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return helper(0, nums.length-1, nums);
    }
    
    public TreeNode helper(int start, int end, int[] nums){
        System.out.println("here!!!!!!");
        int maxIndex = 0, max = Integer.MIN_VALUE;
        for(int i=start; i<=end; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        if((maxIndex-1) >= start)
            root.left = helper(start, maxIndex-1, nums);
        if((maxIndex+1) <= end)
            root.right = helper(maxIndex+1, end, nums);
        return root;
    }
}