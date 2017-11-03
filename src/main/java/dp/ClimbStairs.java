package dp;

public class ClimbStairs {




	int[] stairs;
	
	public int climbStairs(int n){
	    stairs = new int[n];
	    stairs[0] = 0;
	    if(n < 2)
	        return n;
	    else
	        return helper(n);
	}
	
	public int helper(int n){
	    if(n <= 2 )
	        return n;
	    if(stairs[n-1] != 0)
	        return stairs[n-1];
	    else{
	        stairs[n-1] =  helper(n-1) + helper(n-2);
	        return stairs[n-1];
	    }
	}
}