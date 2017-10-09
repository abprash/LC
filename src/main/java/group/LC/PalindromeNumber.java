package group.LC;

public class PalindromeNumber {
/*	
 * Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 * 
 * 	
*/	
	//shitty way of doing it
	//*********************************** DO NOT TRY LIKE THIS!!!!!!!!!!!!!
	
    public boolean isPalindrome(int x) {
        if(x>=0 && x< 10)
            return true;
        if(x<0)
            return false;
        if(x == Integer.MAX_VALUE)
            return false;
        String numberString = Integer.toString(x);
        return helper(numberString);
    }
    
    public boolean helper(String x){
        System.out.println(x);
        if(x == null || x == "" || x.length() == 0 || x.length() == 1)
            return true;
        if(x.length() >= 2 && x.charAt(0) == x.charAt(x.length()-1))            
            return helper(x.substring(1,x.length()-1));
        else
            return false;
    }
    
    //***********************************************************
    //PROPER WAY OF DOING IT
    
    
    
}
