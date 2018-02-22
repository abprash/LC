package group.LC;

public class PrintAllPathsBinaryTree {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public TreeNode printAllPathsBinaryTree(TreeNode root) {
        if(root == null)
            return null;
        helper(root, new ArrayList<>());
        return null;
    }
    
    public void helper(TreeNode root, List<Integer> l){
        if(root == null){
            System.out.println(l);
            //l = new ArrayList<>();
            return;
        }
        if(l == null || l.size() == 0)
            l = new ArrayList<Integer>();
        //l.add(root.val);
        List<Integer> temp  = new ArrayList<>();
        temp.addAll(l);
        temp.add(root.val);
        helper(root.left, temp);
        helper(root.right, temp);
    }
}