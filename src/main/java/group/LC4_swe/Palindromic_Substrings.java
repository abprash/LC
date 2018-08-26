package group.LC4_swe;

public class Palindromic_Substrings {
	
	class Solution {
	    public int countSubstrings(String s) {
	        if(s == null || s.length() == 0)
	            return 0;
	        int ans = 0;
	        
	        for(int i=0; i<s.length(); i++){
	            //get the first center character and start expanding on either sides
	            char c = s.charAt(i);
	            if(i+1 < s.length()){
	                char c1 = s.charAt(i), c2 = s.charAt(i+1);
	                if(c1 == c2)
	                    ans++;
	                int l = i-1, r = i+2;
	                while(c1 == c2 && l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
	                    l--;
	                    r++;
	                    ans++;
	                }
	            }
	            ans++; //for the individual character is a palindrome
	            int l = i-1, r = i+1;
	            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
	                l--;
	                r++;
	                ans++;
	            }
	        }
	        
	        //now consider the even length palindromes
	        // for(int i=0; i<s.length()-1; i++){
	        //     //we will take i and i+1 as the centers and do the same
	        //     char c1 = s.charAt(i), c2 = s.charAt(i+1);
	        //     if(c1 == c2)
	        //         ans++;
	        //     int l = i-1, r = i+2;
	        //     while(c1 == c2 && l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
	        //         l--;
	        //         r++;
	        //         ans++;
	        //     }
	        // }
	        
	        return ans;
	    }
	}

}
