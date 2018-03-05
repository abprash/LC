package group.LC;



//****************************MUCH BETTER Solution

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //check if digit
            if(Character.isDigit(c))
                number = (10 * number) + (c-'0');
            
            else if(c == '+'){
                result += number * sign;
                sign = 1;
                number = 0;
            }
            else if(c == '-'){
                result += number * sign;
                sign = -1;
                number = 0;
            }
            else if(c == '('){
                //push the result first and the sign next
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }
            else if(c == ')'){
                //first add the num calc so far
                result += sign * number;
                number = 0;
                //now go into the stack and collect the prev results
                //first sign will be there
                result*= stack.pop();
                //now the value
                result+= stack.pop();
            }
        }
        if(number != 0)
            result += number*sign;
        return result;
   
    }
}


//*************************************** The solution below did not get accepted, more error handling to be done


public class BasicCalculator {

	//This will work for 75% of the cases
	//just more error handling should be done
	class Solution {
	    public int calculate(String s) {
	        if(s == null || s.length() == 0)
	            return 0;
	        //lets remove leading and trailing spaces
	        s = s.trim();
	        Stack<Character> stack = new Stack<>();
	        //start evaluatng the string
	        for(int i=0; i<s.length(); i++){
	            char c = s.charAt(i);
	            if(c <= '9' && c >= '0'){
	                //push it in
	                stack.push(c);
	            }
	            else if(c == ' ')
	                continue;
	            else if(c == '(')
	                stack.push('(');
	            else if(c ==')'){
	                String rev = "";
	                while(!stack.isEmpty()){
	                    char c1 = stack.pop();
	                    if(c1 != '(')
	                        rev+=""+c1;
	                    else if(c1 =='(')
	                        break;
	                }
	                int ans = subCalc(rev);
	                 
	                    //push back the ans
	                    String ansString = Integer.toString(ans);
	                    System.out.println("***"+ansString);
	                    for(int i1=0; i1<ansString.length(); i1++){
	                        char temp = ansString.charAt(i1);
	                        if(!stack.isEmpty() && (temp == '-' || temp =='+')){
	                          if(temp == '-' && stack.peek() =='-'){
	                              stack.pop();
	                              stack.push('+');
	                          }
	                            else if(temp == '+' && stack.peek() == '+'){
	                                //do not push it in
	                            }
	                            
	                            else if(temp == '-' && stack.peek() == '+'){
	                                stack.pop();
	                              stack.push('-');
	                            }
	                            
	                            else if(temp == '+' && stack.peek() == '-'){
	                               
	                                stack.pop();
	                              stack.push('-');
	                            }
	                        }
	                        else
	                            stack.push(temp);
	                    }
	                    System.out.println("after pushing=="+stack);
	                
	                //keep popping until you get a pair (
	                //construct the string and call calc func and do the same thing again
	                //get the return value and push it back into our stack
	            }
	            else if(c == '+' || c == '-'){
	                stack.push(c);
	            }
	            System.out.println(stack);
	        }
	        if(stack.isEmpty()){
	            return 0;//error case
	        }
	        //there were no parens at all
	        String rev = "";
	        while(!stack.isEmpty()){
	            rev+= ""+stack.pop();
	        }
	        return subCalc(rev);
	    }
	    
	    public int subCalc(String revEqn){
	        String eqn = new StringBuilder(revEqn).reverse().toString();
	        //this eqn will not have ( and ), only nos and signs
	        int i = 0, len = eqn.length();
	        int ans = 0;
	        String prev = "", op = "", num2 = "";
	        //System.out.println(eqn);
	        while( i < len && eqn.charAt(i) != '+' && eqn.charAt(i) != '-'){
	            prev += ""+eqn.charAt(i);
	            //System.out.println(prev);
	            i++;
	        }
	        if(i >= len){
	            return Integer.parseInt(prev);
	        }
	        System.out.println(i);
	        while(i < len){
	            if(i < len && (eqn.charAt(i) == '+' || eqn.charAt(i) == '-')){
	                op += ""+eqn.charAt(i);
	                //System.out.println(op);
	                i++;
	            }
	            while(i < len && eqn.charAt(i) != '+' && eqn.charAt(i) != '-'){
	                num2 += ""+eqn.charAt(i);
	                //System.out.println(num2);
	                i++;
	            }
	            System.out.println(prev+" "+op+" "+num2);
	            //evaluate num1 op and num2
	            if(op.equals("+")){
	                ans = Integer.parseInt(prev) + Integer.parseInt(num2);
	            }
	            else if(op.equals("-")){
	                ans = Integer.parseInt(prev) - Integer.parseInt(num2);
	            }
	            prev = Integer.toString(ans);
	            num2 = "";
	            op= "";
	        }
	        return ans;
	    }
	}
}