package group.LC2;

public class FindLeavesInBT {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null)
            return ans;
        //find the max height of the tree
        int h = getHeight(root);
        
        for(int i=0; i<h; i++)
            ans.add(new ArrayList<>());
        helper(ans,root);
        //System.out.println(ans);
        return ans;
    }
    
    public int getHeight(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    
    public int helper(List<List<Integer>> ans, TreeNode root){
        if(root == null)
            return 0;
        int left = helper(ans, root.left);
        int right = helper(ans, root.right);
        int pos = Math.max(left, right);
        ans.get(pos).add(root.val);
        return 1 + pos;
    }
}