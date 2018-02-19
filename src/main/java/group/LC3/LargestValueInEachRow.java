package group.LC3;

public class LargestValueInEachRow {

	//https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    List<Integer> ans = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        
        //find the max height and create the ans list
        
        if(root == null)
            return ans;
        
        //now test start the traversal 
        //find the max height
        int h = height(root);
        
        for(int i=0; i<h; i++){
            ans.add(Integer.MIN_VALUE);
        }
        
        //do a level order traversal
        bfs(root, 0);
        return ans;
    }
    
    public int height(TreeNode root){
        if(root == null)
            return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
    
    public void bfs(TreeNode root, int level){
        if(root == null)
            return;
        //set the level with the root val
        if(root.val > ans.get(level))
            ans.set(level, root.val);
        
        //go further down
        bfs(root.left, level+1);
        bfs(root.right, level+1);
    }
    
    
}