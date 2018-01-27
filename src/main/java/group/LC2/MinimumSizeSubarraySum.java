package group.LC2;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0, i = 0, j = 0;
        while(j < nums.length){
            sum += nums[j];
            j++;
            while(sum >= s){
                min = Math.min(min, j-i);
                sum-= nums[i];
                i++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}


//Not a good solution
//11/15 cases passed
class Solution {
    int min = Integer.MAX_VALUE;
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int ans = 0;
        backtrack(nums, 0, nums.length-1, s, ans);
        return min;
        
    }
    
    public void backtrack(int[] nums, int start, int end, int s, int ans){
        if(s <= 0){
            //System.out.println(ans);
            if(ans < min)
                min = ans;
            return;
        }
        for(int i=start; i<=end; i++){
            backtrack(nums, i+1, end, s-nums[i], ans+1);
            //s += nums[i];
        }
    }
}