package group.LC;

/*
 * 
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 * 
 * 
 * 
*/
public class RegularExpressionMatching {
	
	

	    public boolean isMatch_Mine(String text, String pattern) {
	        if(pattern.isEmpty())
	            return text.isEmpty();
	        boolean firstMatch = false;
	        if(!text.isEmpty()){
	            firstMatch = (text.charAt(0) == pattern.charAt(0)) || (pattern.charAt(0) == '.');
	        }
	        //now lets check for the * if it is present next
	        if(pattern.length() >= 2 && pattern.charAt(1) == '*'){
	            return (isMatch(text, pattern.substring(2))) || (firstMatch && isMatch(text.substring(1), pattern));
	        }else{
	            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
	        }
	    }
	
	

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() && 
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) || 
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
    
    
    //**************************************DP Solution below
    
    public boolean isMatch(String text, String pattern) {
        if(text == null || pattern == null)
            return false;
        boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
        dp[0][0] = true;
        ///what the hell is this!!!!!!!!!!
        for(int i=0; i<pattern.length(); i++){
            if (pattern.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
        }
        }
        for(int i=0; i<text.length(); i++){
            for(int j=0; j<pattern.length(); j++){
                if(text.charAt(i) == pattern.charAt(j))
                    dp[i+1][j+1] = dp[i][j];//use the prev diag left value
                if(pattern.charAt(j) == '.')
                    dp[i+1][j+1] = dp[i][j];//use the prev diag left value
                if(pattern.charAt(j) == '*'){
                    //this is where it gets interesting
                    //if the prev char in pattern and curr text char do not match AND prev char in text is not .
                    if(pattern.charAt(j-1) != text.charAt(i) && pattern.charAt(j-1) != '.')
                        dp[i+1][j+1] = dp[i+1][j-1];//take the value of the previous result on the table i.e. it does not match
                    else{
                        //this is for the situation where it matches with the prev char,
                        //so it repeats at least once or multiple times
                        //so we use multiple values
                        dp[i+1][j+1] = dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1];
                    }
                }
            }
        }
        return dp[text.length()][pattern.length()];
    }
}