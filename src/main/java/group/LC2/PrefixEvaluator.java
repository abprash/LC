package group.LC2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PrefixEvaluator {

	public static int getPrefixResult(String s) {
		// start evaluating every char in the string
		Stack<String> stack = new Stack<>();
		String[] expression = s.split(" ");
		for(String part : expression)
			stack.push(part);
		String op = "";
		int res = 0;
		List<Integer> list = new ArrayList<>();
		while(!stack.isEmpty()){
			//System.out.println(stack);
			//keep popping and see what all we are getting
			//if its a ), keep popping until you get a corresponding (
			String part = stack.pop();
			if(part.equals(")")){
					continue;
			}
			else if(part.equals("+") || part.equals("*")){
				op = part;
			}
			else if(part.equals("(")){
				//System.out.println(list);
				//evaluate until now and push the res back in the stack
				if(op.equals("+")){
					res = 0;
					Iterator<Integer> iter = list.iterator();
					while(iter.hasNext()){
						res+=iter.next();
						iter.remove();
					}
				}
				else{
					res = 1;
					Iterator<Integer> iter = list.iterator();
					while(iter.hasNext()){
						res*=iter.next();
						iter.remove();
					}
				}
				stack.push(Integer.toString(res));
				if(stack.size() == 1)
					break;
			}
			else{
				//its a number
				int num = Integer.parseInt(part);
				list.add(num);
			}
		}
		
		return Integer.parseInt(stack.pop());
	}

	public static void main(String[] args) {
		String expr2 = "( * 1 2 3 ( + 2 11 12 123 ) ( * 1 2 3 ( + 2 3 5 ) ) )";
		String expr1 = "( + 1 2 33 )";
		String expr3 = "( + 1 2 3 ( + 2 11 12 123 ) )";
		System.out.println(getPrefixResult(expr3));
	}
}
