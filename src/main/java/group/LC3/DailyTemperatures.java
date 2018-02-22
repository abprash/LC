package group.LC3;

import java.util.*;

public class DailyTemperatures {

	//my own solution!!!!!!!
	
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)
            return temperatures;
        
        //this will hold the indices
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            int currTemp = temperatures[i];
            
            //peek the top of the stack
            int top = temperatures[stack.peek()];
            
            //now is the interesting part
            while(!stack.isEmpty() && currTemp > temperatures[stack.peek()]){
                //go update the difference in that location
                int index = stack.pop();
                nums[index] = i - index;
            }
            stack.push(i);
        }
        //we need not worry about the nos in the stack, because they will be 0 anyway - just return the ans
        return nums;
    }
}