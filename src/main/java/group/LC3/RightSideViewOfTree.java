package group.LC;

public class RightSideViewOfTree {

	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public List<Integer> rightSideView(TreeNode root) {
	        
	        //
	        if(root == null)
	            return new ArrayList<Integer>();
	        List<Integer> ans = new ArrayList<>();
	        int currDepth = 0;
	        helper(root, ans, currDepth);
	        return ans;
	    }
	    
	    public void helper(TreeNode root, List<Integer> ans, int depth){
	        if(root == null)
	            return;
	        if(depth == ans.size())
	            ans.add(root.val);
	        //this works because, we add the right node first, and we keep on evaluating the right most nodes
	        //since there is only one right node on every level,
	        //we add only that right node
	        
	        //if we interchange the two invocations below, we will have the left view of tree
	        helper(root.right, ans, depth+1);
	        helper(root.left, ans, depth+1);
	    }
	}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    Queue<TreeNode> q = new LinkedList<TreeNode>();
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();
        q.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        while(q.size() > 0){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null)
                    q.offer(temp.left);
                //push this one in
                l.add(temp.val);
                if(temp.right != null)
                    q.offer(temp.right);
            }
            ans.add(l);
            
        }
        List<Integer> ans2 = new ArrayList<>();
        //now from each value in the list, just take the last element and add it in a new list
        for(List<Integer> l : ans){
            int lastNum = l.get(l.size() - 1);
            ans2.add(lastNum);
        }
        //System.out.println(ans);
        return ans2;
    }
}