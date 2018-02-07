package group.LC;

public class PrintBinaryTree {

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
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        //find the height of the tree
        int h = getHeight(root);
        int width = (int) Math.pow(2,h) - 1;
        System.out.println("W="+width+", height ="+h);
        for(int i=0; i<h; i++){
            List<String> list = new ArrayList<>(width);
            for(int j=0; j<width; j++)
                list.add("");
            ans.add(list);
        }
        //System.out.println(ans);
        //now recursively fill this bitch
        fillList(ans, 0, width, 0, root);
        return ans;
    }
    
    public int getHeight(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    
    public void fillList(List<List<String>> ans, int start, int end, int level, TreeNode root){
        if(root == null)
            return;
        //get the mid
        int mid = (start + end)/2;
        //set the val in list
        ans.get(level).set(mid, ""+root.val);
        //go left and right
        fillList(ans, start, mid-1, level+1, root.left);
        fillList(ans, mid+1, end, level+1, root.right);
        
    }
}