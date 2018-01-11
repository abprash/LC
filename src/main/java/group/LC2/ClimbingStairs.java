package group.LC2;

public class ClimbingStairs {

}

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