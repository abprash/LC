package group.LC2;

import java.util.Stack;

public class PrefixEvaluator {

	public static int getPrefixResult(String s) {
		// start evaluating every char in the string
		if (s == null || s.length() == 0)
			return 0;
		int num = Integer.MIN_VALUE, res = 0, temp = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				if(num != Integer.MIN_VALUE)
					stack.push(num);
				num = 0;
				continue;
			} else if (c <= '9' && c >= '0') {
				num = num * 10 + Character.getNumericValue(c);
			} else if (c == '*' || c == '+') {
				if (c == '+')
					temp = 0;
				else
					temp = 1;
			} else if (c == '(') {
				// carry on for now

			} else if (c == ')') {
				System.out.println(stack);
				// eval the expr so far
				if (temp == 0) {
					res = 0;
					while (!stack.isEmpty())
						res += stack.pop();
				} else {
					res = 1;
					while (!stack.isEmpty())
						res *= stack.pop();
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		String expr2 = "(* 1 2 3 (+ 2 11 12 123) (* 1 2 3 (+2 3 5)))";
		String expr1 = "(* 1 2 33 )";
		System.out.println(getPrefixResult(expr1));
	}
}
