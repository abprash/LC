package group.LC;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if(num == null || num.length() == 0)
            return ans;
        String path = "";
        helper(ans, path, num, target, 0, 0, 0);
        return ans;
    }
    
    public void helper(List<String> ans, String path, String num, int target, int pos, long eval, long multed){
        //multed is the previous product
        //target is the actual number to achieve
        //eval - is the resultant number till now - it is a long so that we will not let overflows happen in ints
        //pos - is the digit we are at
        if(pos == num.length()){
            if(eval == target){
                //we have obtained an answer
                //so add it to ans
                ans.add(path);
                return;
            }
        }
        for(int i=pos; i<num.length(); i++){
            
            //we cannot have numbers starting with 0
            if(i != pos && num.charAt(pos) == '0')
                break;
            
            //this selects a bundle of chars everytime
            long cur = Long.parseLong(num.substring(pos, i+1));
            
            if(pos == 0){
                //this is the first digit, so recursively call again
                helper(ans, path + cur, num, target, i+1, cur, cur);
            }
            else{
                //we have at least one digit now,
                //start applying the operators
                helper(ans, path + "+" + cur, num, target, i+1, eval + cur, cur);
                helper(ans, path + "-" + cur, num, target, i+1, eval - cur, -cur);
                //this is one line i do not understand yet
                //the last line
                //subtracting multed from eval so far, and then adding cur*multed
                helper(ans, path + "*" + cur, num, target, i+1, eval - multed + (multed * cur) , cur * multed);
            }
        }
        
    }
}