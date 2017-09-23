package group.LC;

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
	 

}
