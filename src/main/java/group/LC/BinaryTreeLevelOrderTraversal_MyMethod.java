package group.LC;

public class BinaryTreeLevelOrderTraversal_MyMethod {
	
	//SO proud of myself....my own method
	
	
	
	public List<List<Integer>> levelOrder3(TreeNode root) {
	    if(root == null)
	        return new ArrayList<List<Integer>>();
	    List<List<Integer>> ans = new ArrayList<List<Integer>>();
	    ans.add(new ArrayList<>());
	    helper(root, 0, ans);
	    return ans;
	}
	
	public void helper(TreeNode root, int depth, List<List<Integer>> ans){
	    if(root == null)
	        return;
	    //System.out.println(ans);
	    //now check the ans for that level's element
	    if(ans.size() > depth){
	        //just append it
	        ans.get(depth).add(root.val);
	        //invoke helper on its children
	        helper(root.left, depth+1, ans);
	        helper(root.right, depth+1, ans);
	    }
	    else{
	        List<Integer> temp = new ArrayList<>();
	        temp.add(root.val);
	        ans.add(temp);
	        //invoke helper on its children
	        helper(root.left, depth+1, ans);
	        helper(root.right, depth+1, ans);
	    }
	}

}