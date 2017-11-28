package group.LC;

//MOST BEAUTIFUL SOlution..................... *_*


class Solution {
    public String shortestPalindrome(String s) {
        
        int i = 0, j = s.length() - 1, end = j;
        char[] charSeq = s.toCharArray();
        while(i < j){
            if(charSeq[i] == charSeq[j]){
                i++;
                //we decrement the j pointer here
                j--;
            }else{
                //reset i back to 0
                i=0;
                //but here we decrement the end pointer
                end--;
                //but j will be more ahead than end
                j = end;
            }
        }
        return new StringBuilder(s.substring(end+1)).reverse().toString() + s;
        
    }
}





//*******************************Logic is simple - keep finding the first longest palindrome. (then reverse the rest of the string and prefix it) and then return
//works for 119/120 cases but TLE on the last case

class Solution {
    String ans = new String();
    public String shortestPalindrome(String s) {
        
        if(s == null || s.length() == 0)
            return s;
        
        //the logic is to have a function which will find the first longest palindrome possible,
        //and then reverse the rest of the string and prefix and return
        String part1 = "";
        String temp = "";
        int i = 0;
        for(i=s.length(); i>=0; i--){
            temp = s.substring(0,i);
            if(isPalindrome(temp)){
                break;
            }
        }
        if(i == s.length())
                    return s;
                else{
                    part1 = temp;
                }
        String p1 = "";
        String p2 = "";
        if(i < 0){
            p1 =  new StringBuilder(s.substring(0)).reverse().toString();
            p2 = new StringBuilder(s.substring(0)).toString();
        }
        else{
            p1 = new StringBuilder(s.substring(i)).reverse().toString();
            p2 = new StringBuilder(s.substring(i)).toString();
        }
        //rev the rest of the available string and return
        return p1 + temp + p2;
    }
    
    public boolean isPalindrome(String s){
        //String reversed =  new StringBuilder(s).reverse().toString();
        int i = 0, j = s.length()-1;
        	while(i < j ){
        		if(s.charAt(i) == s.charAt(j)){
        			i++; 
        			j--;
        		}else
        			return false;
        	}
        	return true;
    }
}


//****************** Passed 48/120 cases - still not flawless



class Solution {
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
        
        //iterative approach
        //recursive did not work well
        int left = 0, right = s.length() - 1;
        String temp = s;
        temp = convert("",temp);
        //System.out.println(temp);
        return temp;
        
    }
    
    public String convert(String prefix, String s){
        int left = 0, right = s.length() - 1; 
        while(left  <= right){
            //
            if(s.charAt(right) == s.charAt(left)){
                left++;
            }
            else{
                prefix += s.charAt(right)+"";
                
            }
            right--; 
        }
        //System.out.println("-->"+prefix + s);
        return prefix + s;
    }
}

//********************************************************FAILED

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