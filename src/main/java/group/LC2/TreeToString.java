package group.LC2;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class TreeToString {


    
    StringBuilder sb = new StringBuilder();
    
    public String tree2str(TreeNode t) {
        if(t == null)
            return "";
        sb.append(t.val);
        if(t.left == null && t.right == null)
            return Integer.toString(t.val);
        if((t.left == null && t.right != null) || (t.left != null && t.right != null)){
            sb.append("(");
            tree2str(t.left);
            sb.append(")");
            sb.append("(");
            tree2str(t.right);
            sb.append(")");
        }
        else if(t.left != null && t.right == null){
            sb.append("(");
            tree2str(t.left);
            sb.append(")");
        }
        return sb.toString();
    }
}