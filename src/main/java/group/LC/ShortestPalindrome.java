package group.LC;

public class ShortestPalindrome {

//This recursive solution failed
	//becuase the input string length was >=40,000
	
	//so better to use an iterative process
	
	
    String ans = new String();
    public String shortestPalindrome(String s) {
        
        if(s == null || s.length() == 0)
            return s;
        
        //the logic is, to have a recursive function
        
        //pass it two variables
        //ans and input string
        //check for two conditions
        //if, first and last char in input matches
            //substring them (omit first and last) and carry on
        //else
            //add the last char to the ans string,
            //omit the last char and carry on
        //finally return ans + input as return val
        
        //String ans = new String();
        String copy = new String(s);
        helper( s);    
        //System.out.println(ans);
        return ans + copy;
        
    }
    
    public void helper(String s){
        //base case
        if(s == null || s.length() == 0)
            return;
        int len = s.length();
        if(s.length() == 1)
            return;
        if(s.charAt(len - 1) == s.charAt(0)){
            helper(s.substring(1,len-1));
        }
        else{
            ans = ans+""+s.charAt(len - 1);
            helper(s.substring(0,len-1));
        }
    }
    
    
    
}