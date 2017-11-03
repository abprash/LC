package dp;

public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        //here we have to calc the maximum product sub array
    	//if there are additional non-negative numbers, then we have to take special care as to - include an even number of negative nos.
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[] solution = new int[nums.length];
        int[] solution2 = new int[nums.length];
        solution[0] = nums[0];
        solution2[0] = nums[0];
        for(int i=1; i<nums.length; i++){
        	
        	//with max sum sub array
        	//we had to calc simply one solution array
        	//but with this - we need to calc both max and min - because of the negative numbers 
        	//just add an additional array - to hold both neg and pos max nos.
            solution[i] = Math.max(Math.max(solution[i-1]*nums[i], solution2[i-1]*nums[i]) , nums[i]);
            solution2[i] = Math.min(Math.min(solution[i-1]*nums[i], solution2[i-1]*nums[i]), nums[i]);
        }
        
        //now we do a sweep of the solution array once again
        System.out.println(Arrays.toString(solution));
        System.out.println(Arrays.toString(solution2));
        //now we do a sweep of the two solution arrays to get the max product
        
        
        int max = solution[0];
        for(int i=0;i<solution.length; i++){
            if(solution[i] > max)
                max = solution[i];
            if(solution2[i] > max)
                max = solution2[i];
        }
        return max;
    }
}