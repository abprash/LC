package group.LC4;

import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args){
		System.out.println(~1);
		System.out.println(~0);
	}
}

class Solution {
    //**********************************
    //brute force
    //**********************************
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)
            return temperatures;
        //brute force way
        int[] ans = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++){
            for(int j=i+1; j<temperatures.length; j++){
                if(temperatures[j] > temperatures[i]){
                    ans[i] = j-i;
                    break;
                }
                if(j == temperatures.length)
                    ans[i] = 0;
            }
        }
        return ans;
    }
    
}

/////////////////////////////////////////////////////////////////

class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        
        //**************************************
        //lets try a much more elegant algorithm
        //**************************************
        
        //using stacks
        if(temperatures == null || temperatures.length == 0)
            return temperatures;
        
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<temperatures.length; i++){
            if(stack.isEmpty())
                stack.push(i);
            else{
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    //incoming one is greater, so keep popping, until the current one is the biggest element in stack bottom
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                //now push the temp pos with the highest temp so far 
                stack.push(i);
            }
        }
        return ans;
    }
}