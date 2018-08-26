package group.LC4_swe;

//https://leetcode.com/problems/different-ways-to-add-parentheses/description/

public class DifferentWaysToAddParentheses {

    
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        if(input == null || input.length() == 0)
            return ans;
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> lhs = diffWaysToCompute(input.substring(0,i));
                List<Integer> rhs = diffWaysToCompute(input.substring(i+1, input.length()));
                //evaluate the elements
                for(int l : lhs){
                    for(int r : rhs){
                        if(c == '+')
                            ans.add(l + r);
                        if(c == '-')
                            ans.add(l - r);
                        if(c == '*')
                            ans.add(l * r );
                    }
                }
            }
        }
        if(ans.size() == 0){
            ans.add(Integer.parseInt(input));
        }
        return ans;
    }
    
    
}