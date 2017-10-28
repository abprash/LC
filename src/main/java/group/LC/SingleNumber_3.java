package group.LC;

public class SingleNumber_3 {

	public int[] singleNumber(int[] nums) {
        //initial validation
        
        if(nums == null || nums.length == 0)
            return null;
        
        //here is the logic
        //we XOR all the values in the array
        int both  = nums[0];
        for(int i = 1; i<nums.length; i++){
            both = both ^ nums[i];
        }
        
        //now we should find the place where the numbers differ
        //if we find at least one places where they differ, then we can easily find out the two groups
        
        //find the right most set bit => which means, there was a change in bits there
        int r = both ^ (both &(both-1));
        int num1 = 0, num2 = 0;
        for(int num : nums){
            if((num & r) > 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        int[] ans = new int[]{num1,num2};
        return ans;
    }
}
