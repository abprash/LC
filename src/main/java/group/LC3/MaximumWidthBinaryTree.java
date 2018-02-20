package group.LC3;

public class MaximumWidthBinaryTree {


	//my own AC solution
	//13 ms
	
    public int widthOfBinaryTree(TreeNode root) {
        //we will do a clever recursive solution
        //pass the indices on the imaginary array on every level
        if(root == null)
            return 0;
        int h = height(root);
        int[][] nums = new int[h][2];
        //left one is the min, right one is the max
        for(int[] pair : nums){
            
            //init the array
            pair[0] = Integer.MAX_VALUE;
            pair[1] = Integer.MIN_VALUE;
        }
        
        helper(root, nums, 0, 0);
        int maxDiff = 0;
        for(int[] pair : nums){
            //System.out.println(Arrays.toString(pair));
            maxDiff = Math.max(pair[1]-pair[0] + 1, maxDiff);
        }
        return maxDiff;
    }
    
    public int height(TreeNode root){
        return root == null ? 0 : 1 + Math.max(height(root.left), height(root.right));
    }
    
    public void helper(TreeNode root, int[][] nums, int pos, int d){
        if(root == null)
            return;
        //System.out.println(root.val+", pos ="+pos);
        //fill the nums array
        if(pos < nums[d][0])
            nums[d][0] = pos;
        if(pos > nums[d][1])
            nums[d][1] = pos;
        //go down
        helper(root.left, nums, 2 * pos,d+1);
        helper(root.right, nums, 2 * pos + 1,d+1);
    }
}