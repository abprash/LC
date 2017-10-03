package group.LC;

public class LongestPalindromicSubstring {
    private int maxLen, left;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 1)
            return s;
        for(int i=0; i<s.length(); i++){
            if(i+1 < s.length())
                extendify(s, i, i+1);
            if(i-1 >= 0 && i+1 < s.length())
                extendify(s, i-1, i+1);
        }
        return s.substring(left, maxLen+left);
    }
    
    public void extendify(String s, int c1, int c2){
        //c1 and c2 are the two centers
        while(c1 >= 0 && c2 < s.length() && s.charAt(c1) == s.charAt(c2)){
            c1--;
            c2++;
        }
        if(maxLen < c2-c1-1){
            //we have crossed past the actual letters so we subtract 1 to the right and add 1 to the left
            left = c1 + 1;
            //maxLen is just the length of the palindromic string
            maxLen = c2 - c1 - 1;
        }
    }
    
}
