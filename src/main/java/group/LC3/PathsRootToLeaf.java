package group.LC;

public class PathsRootToLeaf {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null)
            return ans;
        helper(root, ans, new String());
        return ans;
    }
    
    public void helper(TreeNode root, List<String> ans, String path){
        if(root == null)
            return;
        //now we add curr value to path
        //only if root.left and root.right == null, we add path to ans
        System.out.println(path);
        if(path.length() == 0)
            path = Integer.toString(root.val);
        else
            path+="->"+Integer.toString(root.val);
        if(root.left == null && root.right == null)
            ans.add(path);
        helper(root.left, ans, path);
        helper(root.right, ans, path);
    }
}