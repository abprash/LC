package group.LC2;

import java.util.*;

//Another AC solution
//top down + memoization

public class ClimbingStairs {
	    Map<Integer, Integer> map = new HashMap<>();
	    public int climbStairs(int n) {
	        //basically its almost a fibonacci series
	        if(n == 0 || n==1 || n == 2)
	            return n;
	        if(map.containsKey(n))
	            return map.get(n);
	        int ans = climbStairs(n-1) + climbStairs(n-2);
	        map.put(n, ans);
	        return ans;
	    }
	    
	
}


//Bottom up solution
class Solution {
    public int climbStairs(int n) {
        //basically its almost a fibonacci series
        //if n == 0, 1 or 2
    	//return n
    	if(n == 0 || n==1 || n == 2)
            return n;
    	
    	//we now start calc from the 3rd step to n
        int a = 1, b = 2, c = 0;
        for(int i=3; i<=n; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
    
}