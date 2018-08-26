package group.LC4_swe;

//my very own solution... thought from scratch 
//https://leetcode.com/problems/generate-parentheses/description/

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        String s = "";
        List<String> ans = new ArrayList<>();
        int open = n, close = n; 
        helper(s, ans, open, close);
        return ans;
    }
    
    public void helper(String s, List<String> ans, int open, int close){
        // System.out.println(s);
        if(open == 0 && close == 0){
            ans.add(s);
            // System.out.println(ans);
            return;
        }
        else if(close < 0 || open < 0){
            //invalid state
            return;
        }
        else{
            //valid state
            helper(s + "(", ans, open-1, close);
            if(close > open)
                helper(s + ")", ans, open, close-1);
        }
    }
}