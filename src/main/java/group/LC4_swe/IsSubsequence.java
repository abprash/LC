package group.LC4_swe;

//https://leetcode.com/problems/is-subsequence/description/

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(t == null || t.length() == 0){
            if(s == null || s.length() == 0)
                return true;
            else
                return false;
        }
        if(s == null || s.length() == 0)
            return true;
        int ps = 0, pt = 0;
        //check if s is a subsequence of t
        //t is longer, s is shorter
        while(ps < s.length()){
            //if there are no more characters in t
            if(pt == t.length())
                return false;
            pt = t.indexOf(s.charAt(ps), pt);
            if(pt >= 0){
                //the letter was found - 
                pt++;
                ps++;
            }
            else{
                //the letter wasn't found in t
                return false;
            }
        }
        return true;
    }
}