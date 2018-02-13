package group.LC2;

public class MatchSticksToSquare {

}
//DFS solution

//https://leetcode.com/problems/matchsticks-to-square/discuss/95764/Simple-Recursion-Java-solution.-66ms

class Solution {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4)
            return false;
        long sum = 0;
        for(int num : nums)
            sum+= num;
        if(sum %4 != 0)
            return false;
        //long sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
        Arrays.sort(nums);
        
        //Arrays.reverse(nums);
        return dfs(nums, nums.length-1, 0,0,0,0, sum/4);
    }
    
    public boolean dfs(int[] nums, int start, long sum1, long sum2, long sum3, long sum4, long width){
        //check if any of the sides become geater than width
        if(sum1 > width || sum2 > width || sum3 > width || sum4 > width)
            return false;
        
        //check the index length
        //end case
        if(start == -1){
            if(sum1 == width && sum2 == width && sum3 == width && sum4 == width)
                return true;
            else
                return false;
        }
        
        //now do the dfs
        return dfs(nums, start-1, sum1+nums[start], sum2, sum3, sum4, width) ||
            dfs(nums, start-1, sum1, sum2+nums[start], sum3, sum4, width) ||
            dfs(nums, start-1, sum1, sum2, sum3+nums[start], sum4, width) ||
            dfs(nums, start-1, sum1, sum2, sum3, sum4+nums[start], width); 
    }
}