package group.LC2;

import java.util.Stack;



//*********************************MOST BEAUTIFUL SOLUTION EVER!!!!!!!!!!!
//2 pointer and stack...........


class Test{
	public TreeNode str2tree(String s) {
	    Stack<TreeNode> stack = new Stack<>();
	    for(int i = 0, j = i; i < s.length(); i++, j = i){
	        char c = s.charAt(i);
	        if(c == ')')    stack.pop();
	        else if(c >= '0' && c <= '9' || c == '-'){
	            while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
	            TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
	            if(!stack.isEmpty()){
	                TreeNode parent = stack.peek();
	                if(parent.left != null)    parent.right = currentNode;
	                else parent.left = currentNode;
	            }
	            stack.push(currentNode);
	        }
	    }
	    return stack.isEmpty() ? null : stack.peek();
	}
}
//***********************************
/**
 * Definition for a binary tree node.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class StringToTree {

	public TreeNode str2tree(String s) {
		if (s == null)
			return null;
		// so the core logic is,
		// if we encounter a (, we go down either to the left or right child
		// depending on whats available
		// if we encounter a ), we go up to the parent
		TreeNode root = null;
		TreeNode cur = root;
		TreeNode prev = null;
		int num = 0;
		Stack<TreeNode> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				// go down one level
				// push the cur node into the stack
				stack.push(cur);
				cur = null;
			}
			if (c == ')') {
				// go up one level
				// pop the stack now
				if (!stack.isEmpty())
					cur = stack.pop();
			}
			if (c <= '9' && c >= '0') {
				// we have a number
				if (i > 0 && s.charAt(i - 1) == '-')
					num = -1 * (num * 10 + Character.getNumericValue(c));
				else
					num = num * 10 + Character.getNumericValue(c);

				if (((i + 1) < s.length()) && !(s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0')) {
					cur = new TreeNode(num);
					// System.out.println(num);
					num = 0;
				} else if (i == s.length() - 1) {
					cur = new TreeNode(num);
					// System.out.println(num);
					num = 0;
				}
				if (!stack.isEmpty()) {
					if (stack.peek() != null && stack.peek().left == null)
						stack.peek().left = cur;
					else if (stack.peek() != null && stack.peek().right == null)
						stack.peek().right = cur;
				} else
					root = cur;
			}
		}
		return root;
	}
	// we need a helper function to take in, the index of string,
	// the string
	//
}
