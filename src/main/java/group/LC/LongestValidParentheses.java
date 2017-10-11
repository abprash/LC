package group.LC;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0 || s.length() == 1)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        //System.out.println(s.length());
        int maxLength=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            //check if its a open or close paren
            if(c == '('){
                //push it in stack - no problems
                stack.push(i);
            }
            else if(c == ')'){
                
                if(stack.size() == 0)
                    stack.push(i);
                else if(s.charAt(stack.peek())=='(')
                        stack.pop();
                else
                    stack.push(i);
            }
        }
        //System.out.println(stack);
        //now we have the positions where the invalid parens creep up in the string
        //so now we simply start taking out the values in the stack and keep subtracting successive entries
        if(stack.isEmpty())
            return s.length();
        
        //there are some invalid chars in the string
        int a = s.length(), b = 0;
        while(!stack.isEmpty()){
            b = stack.peek();
            stack.pop();
            maxLength = Math.max(maxLength, a-b-1);
            a=b;
        }
        maxLength = Math.max(maxLength,a);
        return maxLength;
    }
}