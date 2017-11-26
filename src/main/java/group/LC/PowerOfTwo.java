package group.LC;

public class PowerOfTwo {
	
	
	//
	/*
	 * Different ways to approach this
	 * 1) n & n-1 should always be 0. coz 8-1000 and 7 - 111. so 1000&111 = 0. Always
	 * 2) There will always be 1 bit set in a power of 2. so we can use bitcount
	 * 3) We can keep dividing by 2. Until we reach a quotient of 1. O(logN) - Iterative and recursive
	 * 4) 
	 * 
	 * Because the range of an integer = -2147483648 (-2^31) ~ 2147483647 (2^31-1), the max possible power of two = 2^30 = 1073741824.

(1) If n is the power of two, let n = 2^k, where k is an integer.

We have 2^30 = (2^k) * 2^(30-k), which means (2^30 % 2^k) == 0.

(2) If n is not the power of two, let n = j*(2^k), where k is an integer and j is an odd number.

We have (2^30 % j*(2^k)) == (2^(30-k) % j) != 0.

	 * 
	 * 
	 * */
	
	
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        int dup = n-1;
        if((n & dup) == 0)
            return true;
        else
            return false;
        
    }
    //*********************************
    
    public boolean isPowerOfTwo2(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
    
    
    //************************************
    
    public boolean isPowerOfTwo3(int n) {
    	return n>0 && (1073741824 % n == 0);
    }
}