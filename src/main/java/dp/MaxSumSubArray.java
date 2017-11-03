package dp;

public class MaxSumSubArray {


    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[] solution = new int[nums.length];
        solution[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            //now using DP, we know that
            // its a chain of max sum of consec elements
            
            //the real logic here is, it either has to extend from the previously calc sum or start afresh
            solution[i] = Math.max(solution[i-1] + nums[i], nums[i]);
        }
        System.out.println(Arrays.toString(solution));
        int max = Integer.MIN_VALUE;
        //then we do a sweep of the solution array to get the max number - which is the max sum
        for(int i=0; i<solution.length; i++){
            if(solution[i] > max)
                max = solution[i];
        }
        return max;
    }
}