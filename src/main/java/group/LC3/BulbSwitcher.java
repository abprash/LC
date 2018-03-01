package group.LC3;


import java.util.*;

public class BulbSwitcher {

	
	//https://leetcode.com/problems/bulb-switcher/discuss/77133/My-0-ms-C++-solution-with-explanation
	
	
	public int bulbSwitch2(int n) {
        if(n <= 1)
            return n;
        int count = 0;
        for(int i=1; i*i <= n; i++){
            count++;
        }
        return count;
    }
	
	
	
	    public int bulbSwitch(int n) {
	        
	        //https://leetcode.com/problems/bulb-switcher/discuss/77145/Crystal-clear-explanation-one-line-c++-code
	        
	        return (int) Math.sqrt(n);
	    }

}


//***************************BRute force algo

class Solution {
    public int bulbSwitch(int n) {
        if(n <= 1)
            return n;
        //initially all bulbs are off
        int[] nums = new int[n];
        //first round - turn on all bulbs
        Arrays.fill(nums, 1);
        
        //2nd round - turn off every second bulb
        roundOne(nums);
        if(nums.length > 3){
            for(int i=2; i<nums.length-1; i++){
                //turn off every i th bulb
                int j = i;
                while(j < nums.length){
                    //toggle
                    if(nums[j] == 1)
                        nums[j] = 0;
                    else
                        nums[j] = 1;
                    j += (i+1);
                }
            }
        }
        
        //final round - toggle the last bulb alone
        int last = nums.length-1;
        if(nums[last] == 1)
            nums[last] = 0;
        else
            nums[last] = 1;
        
        //count the num of on bulbs
        return finalCount(nums);
    }
    
    public void roundOne(int[] nums){
        if(nums.length <= 2)
            return;
        for(int i=1; i<nums.length; i+=2){
            nums[i] = 0;
        }
    }
    
    public int finalCount(int[] nums){
        int sum = 0;
        for(int i : nums)
            sum+=i;
        return sum;
    }
}