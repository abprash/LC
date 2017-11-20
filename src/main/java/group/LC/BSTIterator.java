package group.LC;

public class BSTIterator {


	
	//*********************BETTER SOLUTION
	
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	public class BSTIterator {

	    TreeNode root;
	    //List<Integer> list = new ArrayList<>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode curNode = null;
	    static int counter = 0;
	    static int size = 0;
	    List<Integer> next = null;
	    public void loadTree(TreeNode root){
	        if(root == null)
	            return;
	        //go left
	        //System.out.println(root.val);
	        while(root != null){
	            stack.push(root);
	            root = root.left;
	        }
	        return;
	    }
	    
	    public BSTIterator(TreeNode root) {
	        this.root = root;
	        loadTree(root);
	        //System.out.println(list);
	        //size = list.size();
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	       return (!stack.isEmpty());
	    }

	    /** @return the next smallest number */
	    public int next() {
	        //pop the node in stack immediately
	        TreeNode node = stack.pop();
	        //assign as the cur node
	        TreeNode cur = node;
	        
	        // traversal right branch.... this is the important part here
	        //first the right ones, then the left child of the right ones
	        if(cur.right != null){
	            cur = cur.right;
	            while(cur != null){
	                stack.push(cur);
	                if(cur.left != null)
	                    cur = cur.left;
	                else
	                    break;
	            }
	        }
	        return node.val;
	    }
	}

	/**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
	
	
	//*********************************
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


    TreeNode root;
    List<Integer> list = new ArrayList<>();
    static int counter = 0;
    static int size = 0;
    
    public void loadTree(TreeNode root){
        if(root == null)
            return;
        //go left
        //System.out.println(root.val);
        loadTree(root.left);
        list.add(root.val);
        loadTree(root.right);
        return;
    }
    
    public BSTIterator(TreeNode root) {
        this.root = root;
        loadTree(root);
        //System.out.println(list);
        size = list.size();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
       if(counter < list.size())
           return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        //if(counter < list.size())
        int ans = list.get(counter);
        counter++;
        return ans;
        
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */