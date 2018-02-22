package group.LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals {
	
	public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return null;
        //Preorder traversal
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(stack.size() > 0){
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
        return new ArrayList<Integer>();
    }
	
	 public List<Integer> inorderTraversal(TreeNode root) {
	        if(root == null)
	            return new ArrayList<Integer>();
	        //Preorder traversal
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode cur = root;
	        List<Integer> list = new ArrayList<Integer>();
	        while(cur != null || !stack.empty()){
	            //we will be collecting all the left nodes and root finally into the stack
	            while(cur != null){
	                stack.push(cur);
	                cur = cur.left;
	            }
	            cur = stack.pop();
	            list.add(cur.val);
	            //System.out.println(cur.val);
	            cur = cur.right;
	        }
	        return list;
	    }
	 
	 //for postorder traversal - keep putting in the right nodes first into the stack
	 //and keep going in to the above method
	 
	 
	 //************************level order traversal and returning the answer as a List of lists
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        if(root == null)
	            return new ArrayList<List<Integer>>();
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        List<List<Integer>> ans = new ArrayList<List<Integer>>();
	        //ans.add(Arrays.asList(new Integer[]{root.val}));
	        while(!q.isEmpty()){
	            List<Integer> subList = new ArrayList<>();
	            ///determine the size of the sublist
	            int levelLength = q.size();
	            for(int i=0; i<levelLength; i++){
	                if(q.peek().left != null)
	                    q.add(q.peek().left);
	                if(q.peek().right != null)
	                    q.add(q.peek().right);
	                subList.add(q.remove().val);
	            }
	            ans.add(subList);
	        }
	        return ans;
	    }
	 
	 //************************IS complete binary tree
	 public boolean isComplete(TreeNode root) {
	        if(root == null)
	            return true;
	        if(root.left== null && root.right == null)
	            return true;
	        if(root.left == null || root.right == null)
	            return false;
	        return isComplete(root.left) && isComplete(root.right);
	    }
	 
	 //*************************PRE
	 
	 public void preOrderTraversal(TreeNode root){
	        
	        //iterative
	        if(root == null)
	            return;
	        Stack<TreeNode> stack = new Stack<>();
	        stack.push(root);
	        while(!stack.isEmpty()){
	            TreeNode temp = stack.pop();
	            //System.out.println(stack);
	            System.out.println(temp.val);
	            if(temp.right != null)
	                stack.push(temp.right);
	            if(temp.left != null)
	                stack.push(temp.left);
	            
	        }
	        return;
	    }

	 //*********************************POST
	 
	 
	 public List<Integer> postorderTraversal(TreeNode root) {
		    List<Integer> res = new ArrayList<Integer>();
		 
		    if(root==null) {
		        return res;
		    }
		 
		    Stack<TreeNode> stack = new Stack<TreeNode>();
		    stack.push(root);
		 
		    while(!stack.isEmpty()) {
		        TreeNode temp = stack.peek();
		        if(temp.left==null && temp.right==null) {
		            TreeNode pop = stack.pop();
		            res.add(pop.val);
		        }
		        else {
		            if(temp.right!=null) {
		                stack.push(temp.right);
		                temp.right = null;
		            }
		 
		            if(temp.left!=null) {
		                stack.push(temp.left);
		                temp.left = null;
		            }
		        }
		    }
		 
		    return res;
		}
	 
	 //**************************INORDER
	 
	 public List<Integer> inorderTraversal2(TreeNode root) {
		    List<Integer> result = new ArrayList<Integer>();
		    if(root==null)
		        return result;
		    Stack<TreeNode> stack = new Stack<TreeNode>();
		    stack.push(root);
		 
		    while(!stack.isEmpty()){

		        TreeNode top = stack.peek();
		        System.out.println(">>"+top.val);
		        if(top.left!=null){
		            //first we need to push all the left nodes 
		            //go until we are all the way down
		            stack.push(top.left);
		            top.left=null;
		        }else{
		            
		            //this is where we are printing them in order
		            result.add(top.val);
		            
		            //we are evacuating the left node from the stack
		            stack.pop();
		            
		            //but top still points to the parent - so it will be printed next, but the right child will be going into the stack, so it will be printed afer the parent
		            if(top.right!=null){
		                stack.push(top.right);
		            }
		        }
		    }
		 
		    return result;
		}
}
