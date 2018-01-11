package group.LC;




class Solution {
    public int rob(int[] nums) {
        //
        int a = 0, b = 0;
        if(nums == null || nums.length == 0)
            return 0;
        //now lets try a dp solution
        //the core concept being
        
        int[] money = new int[nums.length];
        money[0] = nums[0];
        
        //if single element
        if(nums.length == 1)
            return money[0];
        
        //if 2
        money[1] = Math.max(nums[0], nums[1]);
        if(nums.length <= 2)
            return money[nums.length-1];
        
        //now lets do dp
        for(int i=2; i<nums.length; i++){
            //we have to take the max of
            //curr cell + cur-2 money cell OR past money cell
            money[i] = Math.max(money[i-2] + nums[i], money[i-1]);
        }
        
        return money[nums.length-1];
    }
}

//ALTERNATE Solution***********************


public class HouseRobber {

	
    public int rob(int[] nums) {
        //
        int a = 0, b = 0;
        if(nums == null || nums.length == 0)
            return 0;
        for(int i=0; i<nums.length; i++){
            if(i%2 == 0)
                a = Math.max(a+nums[i], b); //add it to a, and assign the max to a
            else
                b = Math.max(a, b+nums[i]); // add curr val. to b, and assign max to b 
        }
        return Math.max(a, b);
    }
}