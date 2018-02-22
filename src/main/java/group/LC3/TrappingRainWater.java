package group.LC;


/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * 
 * 
 * */
//*********************Correct approach using two pointers

class Solution {
    public int trap(int[] nums) {
        //
        
        if(nums == null || nums.length <= 1)
            return 0;
        
        int leftMax = 0, rightMax = 0, left = 0, right = nums.length - 1, ans = 0;
        while(left < right){
            if(nums[left] < nums[right]){
                //compare it with leftmax
                //add the volume
                if(nums[left] >= leftMax)
                    leftMax = nums[left];
                else
                    ans += (leftMax - nums[left]);
                left++;
            }
            else{
                if(nums[right] >= rightMax)
                    rightMax = nums[right];
                else
                    ans += rightMax - nums[right];
                right--;
            }
        }
        return ans;
        
    }
}







//the following is a greedy approach - will not work
//it passed only 150/315 cases

public class TrappingRainWater {


    public int trap(int[] nums) {
        //initial validation
        if(nums == null || nums.length <= 1)
            return 0;
        //lets find the water pocket areas
        int left = 0;
        int right = 1;
        int ans = 0;
        boolean isDip = false, isRise = false;
        while(left < nums.length && right < nums.length){
            if(nums[left] < nums[right] && !isDip){
                left++;
                right++;
            }
            else if(nums[left] > nums[right]){
                isDip = true;
                //measuring the dip
                while(right < nums.length && right+1 < nums.length && nums[right] >= nums[right+1])
                    right++;
                //now the rise
                while(right < nums.length && right+1 < nums.length && nums[right] <= nums[right+1]){
                    isRise = true;
                    right++;
                    
                }
                
                //what if there is a smaller rise and then a dip and bigger rise
                if(isRise && isDip)
                    System.out.println("left = "+left+", right="+right);
                ans +=  calcWaterLevel(nums, left, right);
                isRise = false;
                isDip = false;
                left = right;
                right = left+1;
                
            }
            else if(nums[left] == nums[right]){
                left++;
                right++;
            }
        }
        return ans;
    }
    
    
    public int calcWaterLevel(int[] nums, int left, int right){
        if(left > nums.length - 1 || right > nums.length - 1)
            return 0;
        //left is where the water pocket starts, and right is where it ends
        //so we have to calc the water level
        
        //find the min between the two extremes and keep it as waterHeight
        //then find what the difference between each num and water height
        
        int waterHeight = Math.min(nums[left], nums[right]);
        System.out.println(waterHeight);
        int sum = 0;
        for(int i=left; i<= right; i++){
            if(waterHeight >= nums[i])
                sum+=(waterHeight - nums[i]);
        }
        return sum;
    }
}
