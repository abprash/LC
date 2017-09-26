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

}
