package dp;

public class LongestIncreasingSubsequence {


    int max = Integer.MIN_VALUE;
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        //base case
        if(nums.length == 1)
            return 1;
        //have an array to store the LIS till each element in the array
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                //check if the i'th num is in fact greater than j'th
                if(nums[j] < nums[i]){
                    //check the already existing count in dp[i]
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        max = Math.max(max, dp[i]);
                    }
                }
            }
        }
        //for(int i=0; i<dp.length; i++)
            
        return max == Integer.MIN_VALUE ? 1 : max;
    }
}