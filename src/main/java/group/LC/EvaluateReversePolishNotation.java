package group.LC;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * 
*/
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            //check the char we have first
            //if its a symbol, start popping the stack and apply the symbol
            //else
            //push the nos into the stack and keep
            
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int num1 = 0, num2 = 0;
                //int[] nums = {num1, num2};
                if(!stack.isEmpty()){
                    //pop twice
                    num1 = stack.pop();
                    num2 = stack.pop();
                    //apply the operations and push it back
                    if(token.equals("/"))
                        stack.push(num2/num1);
                    else if(token.equals("-"))
                        stack.push(num2-num1);
                    else if(token.equals("+"))
                        stack.push(num2+num1);
                    else if(token.equals("*"))
                        stack.push(num2*num1);
                }
            }
            else{
                //simply push them
                stack.push(Integer.parseInt(token));
            }
        }return (int) stack.pop();
    }
}