package group.LC4;

//https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;
        int prodSoFar = 1;
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i=1; i<nums.length; i++){
            prodSoFar *= nums[i-1];
            ans[i] = prodSoFar;
        }
        // System.out.println(Arrays.toString(ans));
        prodSoFar = 1;
        for(int i=nums.length-2; i>=0; i--){
            prodSoFar *= nums[i+1];
            ans[i] *= prodSoFar;
        }
        
        return ans;
    }
}