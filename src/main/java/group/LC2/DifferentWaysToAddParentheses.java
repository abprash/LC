package group.LC2;

public class DifferentWaysToAddParentheses {


    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                //now split the rest of the string into 2 parts
                String left = input.substring(0, i);
                String right = input.substring(i+1);
                List<Integer> leftAns =  diffWaysToCompute(left);
                List<Integer> rightAns =  diffWaysToCompute(right);
                int res = 0;
                for(int a : leftAns){
                    for(int b : rightAns){
                        if(c == '+')
                            res = a+b;
                        if(c == '-')
                            res = a-b;
                        if(c == '*')
                            res = a*b;
                        ans.add(res);
                    }
                }
            }
        }
        if(ans.size() == 0)
            ans.add(Integer.parseInt(input));
        return ans;
    }
}